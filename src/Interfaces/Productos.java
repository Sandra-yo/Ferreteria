/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import baseDatos.ProductosBD;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aldair
 */
public class Productos {
    public String nombres[]={"Id","Nombre","Categoria","Cantidad","Cantidad minima","Precio unitario","precio Mayoreo","precio proveedor"};
    public JTextField campos[];
    public JLabel titulos[];
    public JPanel panelC,panel1,panel2,panel3,panel4,panelA,panelB;
    public ImageIcon imagen,nuevo,elim,busq;
    public JLabel image,nom;
    public JTable tabla;
    public DefaultTableModel dtm;
    public JTextArea text;
    public JScrollPane c;
    private ProductosBD productos;
    private JButton agregar,borrar,buscar,mas,menos;
    private JLabel inventario, invCant;
    private ProductosBD prod;
   
    public Productos(){
        panelC = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panelA = new JPanel();
        panelB = new JPanel();

        
        //clases
        productos = new ProductosBD();
        
        //imagenes
        imagen = new ImageIcon(getClass().getResource("../imagenes/notFound.jpg"));
        image = new JLabel(imagen);
        nuevo = new ImageIcon("Agregar");
        elim = new ImageIcon(getClass().getResource("../imagenes/trash.png"));
        busq = new ImageIcon(getClass().getResource("../imagenes/search.png"));

        
        //tablas
        productos.agregarColumnas();
        tabla= new JTable(productos.dtm);
        this.armarTablas();
        
        panelC.setLayout(new GridLayout(3,1));
        panel2.setLayout(new GridLayout(1,1));
        panel1.setLayout(new GridLayout(1,1));
        panelA.setLayout(new GridLayout(8,1));
        panelB.setLayout(new GridLayout(1,1));
        panel3.setLayout(null);
        panel4.setLayout(new GridLayout(1,1));
        
        //aumento y decremento del inventario
        inventario = new JLabel("Inventario");
        invCant = new JLabel(""+0);
        mas = new JButton("+");
        menos = new JButton("-");
        
        
        //textarea
        JLabel nom= new JLabel("Descripciòn:");
        text= new JTextArea();
        c = new JScrollPane(text);
        
        inventario.setBounds(10,0,100,50);        
        invCant.setBounds(90,0,100,50); 
        mas.setBounds(170,10,50,30);
        menos.setBounds(110,10,50,30);
        nom.setBounds(10,30,100,50);
        c.setBounds(10,70,1200,100);
        
        //botones
        agregar = new JButton("Agregar");
        agregar.setBounds(1220,40,100,30);
        agregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               agregarProducto();
               
            }
        });
        borrar = new JButton("Eliminar");
        borrar.setBounds(1220,80,100,30);
        buscar = new JButton("Buscar");
        buscar.setBounds(1220,120,100,30);
        
        campos = new JTextField[nombres.length];
        titulos= new JLabel[nombres.length];
       
        
        for (int i= 0; i < nombres.length; i++) {
            campos[i]= new JTextField();
            titulos[i]= new JLabel(nombres[i]);
            panelA.add(titulos[i]);
            panelA.add(campos[i]);
        }
        panel2.add(panelA);
        panelB.add(image);
        panel2.add(panelB);     
        panel3.add(inventario);
        panel3.add(invCant);
        panel3.add(mas);   
        panel3.add(menos);   
        panel3.add(nom);
        panel3.add(c);
        panel3.add(agregar);
        panel3.add(borrar);
        panel3.add(buscar);        
        panel4.add(new JScrollPane(tabla));
        
      //  panelC.add(panel1);
        panelC.add(panel2);
        panelC.add(panel3);
        panelC.add(panel4);
        
        tabla.addMouseListener(new Escucha());

    }
     public void armarTablas(){
         tabla = new JTable(productos.llenarTabla());
     }
     public void agregarProducto(){
         productos.setNombre(campos[1].getText());
         productos.setCategoria(campos[2].getText());
         productos.setCantidad(Integer.parseInt(campos[3].getText()));
         productos.setCantidadMin(Integer.parseInt(campos[4].getText()));
         productos.setPrecioU(Integer.parseInt(campos[5].getText()));
         productos.setPrecioM(Integer.parseInt(campos[6].getText()));
         productos.setPrecioP(Integer.parseInt(campos[7].getText()));
         productos.agregar();
         productos.actualizarTabla();
         armarTablas();
         

     }
     
      private class Escucha extends MouseAdapter {
           public void mouseClicked(MouseEvent evento) {
               try{
                   System.out.println("Sss");
                campos[0].setText(Integer.toString((int) dtm.getValueAt(tabla.getSelectedRow(), 0)));
                campos[1].setText((String) prod.dtm.getValueAt(tabla.getSelectedRow(), 1));
                campos[2].setText((String) prod.dtm.getValueAt(tabla.getSelectedRow(), 2));
                campos[3].setText(Integer.toString((int) prod.dtm.getValueAt(tabla.getSelectedRow(), 3)));
                campos[4].setText(Integer.toString((int) prod.dtm.getValueAt(tabla.getSelectedRow(), 4)));
                campos[5].setText(Integer.toString((int) prod.dtm.getValueAt(tabla.getSelectedRow(), 5)));
                campos[6].setText(Integer.toString((int) prod.dtm.getValueAt(tabla.getSelectedRow(), 6)));
                campos[7].setText(Integer.toString((int) prod.dtm.getValueAt(tabla.getSelectedRow(), 7))); 
               
               }catch(Exception e){
                   System.out.println(e);
                }
               
           }
          
      }
    
}
