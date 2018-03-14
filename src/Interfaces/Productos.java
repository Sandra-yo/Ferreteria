/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Aldair
 */
public class Productos {
    public String nombre[]={"Id","Nombre","Categoria","Cantidad","Cantidad minima","Precio unitario","precio Mayoreo","precio proveedor"};
    public JTextField campos[];
    public JLabel titulos[];
    public JPanel panelC,panel1,panel2;
    public ImageIcon imagen;
    public JLabel image;
   
    public Productos(){
        panelC = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        imagen = new ImageIcon(getClass().getResource("../imagenes/notFound.jpg"));
        image = new JLabel(imagen);
        
        panelC.setLayout(new GridLayout(5,4));
        panel2.setLayout(new GridLayout(4,4));
        panel1.setLayout(new GridLayout(1,1));
        campos = new JTextField[nombre.length];
        titulos= new JLabel[nombre.length];
       
        
        for (int i = 0; i < nombre.length; i++) {
            campos[i]= new JTextField();
            titulos[i]= new JLabel(nombre[i]);
            panel2.add(titulos[i]);
            panel2.add(campos[i]);
        }
        panel1.add(image);
        
        panelC.add(panel1);
        panelC.add(panel2);
    }
    
}
