/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.GridLayout;
import java.awt.Scrollbar;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aldair
 */
public class Productos {
    public Object nombre[]={"Id","Nombre","Categoria","Cantidad","Cantidad minima","Precio unitario","precio Mayoreo","precio proveedor"};
    public String nombres[]={"Id","Nombre","Categoria","Cantidad","Cantidad minima","Precio unitario","precio Mayoreo","precio proveedor"};
    public Object filas[][]={{"a","b","c","d","e","f","g","e","f"},{}};
    public JTextField campos[];
    public JLabel titulos[];
    public JPanel panelC,panel1,panel2,panel3;
    public ImageIcon imagen;
    public JLabel image;
    public JTable tabla;
    public DefaultTableModel dtm;
    public JScrollBar c;
   
    public Productos(){
        panelC = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        imagen = new ImageIcon(getClass().getResource("../imagenes/notFound.png"));
        image = new JLabel(imagen);
        dtm= new DefaultTableModel(filas,nombre);
        tabla= new JTable(dtm);
        c = new JScrollBar();
        
        panelC.setLayout(new GridLayout(4,1));
        panel2.setLayout(new GridLayout(4,4));
        panel1.setLayout(new GridLayout(1,1));
        panel3.setLayout(null);
        campos = new JTextField[nombre.length];
        titulos= new JLabel[nombre.length];
       
        
        for (int i= 0; i < nombre.length; i++) {
            campos[i]= new JTextField();
            titulos[i]= new JLabel(nombres[i]);
            panel2.add(titulos[i]);
            panel2.add(campos[i]);
        }
        tabla.setSize(900,400);
        c.add(tabla);
        c.setBounds(100,100,700,700);
        
        panel1.add(image);
        panel3.add(c);
        
        
        panelC.add(panel1);
        panelC.add(panel2);
        panelC.add(panel3);
    }
    
}
