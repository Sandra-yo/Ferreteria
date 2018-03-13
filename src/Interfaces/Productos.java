/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

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
    public JPanel panel;
   
    public Productos(){
        panel= new JPanel();
        campos = new JTextField[nombre.length];
        titulos= new JLabel[nombre.length];
       
        
        for (int i = 0; i < nombre.length; i++) {
            campos[i]= new JTextField();
            titulos[i]= new JLabel();
        }
        
    }
    
}
