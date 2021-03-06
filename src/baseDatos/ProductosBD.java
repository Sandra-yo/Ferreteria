 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import static baseDatos.Conexion.conectarBD;
import static baseDatos.Conexion.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aldair
 */
public class ProductosBD {
    private int id;
    private String nombre;
    private String categoria;
    private int cantidad;
    private int cantidadMin;
    private int precioU;
    private int precioM;
    private int precioP;
    public DefaultTableModel dtm;
    
    public ProductosBD(){
        dtm = new DefaultTableModel();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidadMin() {
        return cantidadMin;
    }

    public void setCantidadMin(int cantidadMin) {
        this.cantidadMin = cantidadMin;
    }

    public int getPrecioU() {
        return precioU;
    }

    public void setPrecioU(int precioU) {
        this.precioU = precioU;
    }

    public int getPrecioM() {
        return precioM;
    }

    public void setPrecioM(int precioM) {
        this.precioM = precioM;
    }

    public int getPrecioP() {
        return precioP;
    }

    public void setPrecioP(int precioP) {
        this.precioP = precioP;
    }
    //metodos
    
    public void agregarColumnas(){
        dtm.addColumn("ID");
        dtm.addColumn("Nombre");
        dtm.addColumn("Categoria");
        dtm.addColumn("Existencia");
        dtm.addColumn("Existencia Minima");
        dtm.addColumn("Precio Unitario");
        dtm.addColumn("Precio Mayoreo");
        dtm.addColumn("Precio Proveedor");

    }
    
    public DefaultTableModel llenarTabla(){
        conectarBD();
        try{
            if(!conexion.isClosed()){
                Statement st= conexion.createStatement();
                ResultSet rs= st.executeQuery("select * from Productos");
                while(rs.next()){
                    Object fila[] = new Object[8];
                    fila[0]=rs.getObject(1); 
                    fila[1]=rs.getObject(2); 
                    fila[2]=rs.getObject(3); 
                    fila[3]=rs.getObject(4); 
                    fila[4]=rs.getObject(5); 
                    fila[5]=rs.getObject(6); 
                    fila[6]=rs.getObject(7); 
                    fila[7]=rs.getObject(8);
                    
                    dtm.addRow(fila);
                    
                }
                //JOptionPane.showMessageDialog(null,"Registro exitoso");
            conexion.close();
            }
        }catch(Exception e){
            System.err.print(e);
        }
        return dtm;
    }
    
    public void agregar(){
        conectarBD();
        String sql="insert into Productos(nombre,categoria,cantidad,minima,precioU,precioM,precioProv) values(?,?,?,?,?,?,?);";
        try{
            if(!conexion.isClosed()){
                PreparedStatement ps= conexion.prepareStatement(sql);
                
                ps.setString(1, this.nombre);
                ps.setString(2, this.categoria);
                ps.setInt(3, this.cantidad);
                ps.setInt(4, this.cantidadMin);
                ps.setInt(5, this.precioU);
                ps.setInt(6, this.precioM);
                ps.setInt(7, this.precioP);
                
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null,"Registro exitoso");
                
               conexion.close();
            }
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
    
    public boolean borrar() throws SQLException{
         conectarBD(); 
         String sql="delete from Productos where id="+this.id;
         if(Conexion.ejecutarSQLUpdate(sql)){
             
             JOptionPane.showMessageDialog(null,"Borrado exitoso");
             conexion.close();
             return true;
         }else{
             return false;
         }
         
    }
    
    public void borrarTabla(){
        do{
           dtm.removeRow(dtm.getRowCount()-1);
        }while(dtm.getRowCount()!=0);
    }
    
    public void actualizarTabla(){
        borrarTabla();
        
    }
    public void datosDelaTabla(int f,int c){
        dtm.getValueAt(f, c);
        System.out.println(dtm.getValueAt(f, c));
        conectarBD();
          String sql="select*from Productos where id=;"+id;
       
        try{
            if(!conexion.isClosed()){
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
            }
        
    }catch(Exception e){
            System.err.println(e);
        
    }
    }
    public DefaultTableModel BuscarTabla(String tipo,String valor){
            conectarBD();
            String sql="select*from Productos where "+tipo+"= '"+valor+"'";
            try{
                if(!conexion.isClosed()){
                    Statement st= conexion.createStatement();
                    ResultSet rs=st.executeQuery(sql);
                    while(rs.next()){
                    Object fila[] = new Object[8];
                    fila[0]=rs.getObject(1); 
                    fila[1]=rs.getObject(2); 
                    fila[2]=rs.getObject(3); 
                    fila[3]=rs.getObject(4); 
                    fila[4]=rs.getObject(5); 
                    fila[5]=rs.getObject(6); 
                    fila[6]=rs.getObject(7); 
                    fila[7]=rs.getObject(8);
                    
                    dtm.addRow(fila);
                    
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }
                
            
        return dtm;
        
    }
    
}
