/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

/**
 *
 * @author Aldair
 */
public class Central extends JFrame{
     
     public JMenuBar barra;
     public JMenu menu[];
     public JMenuItem items[];
     public String nombre[]={"Archivo","Configuracion","Extras"};
     public Productos prod;
     
     public Central(){
        //parte general del programa
         super ("Ferreteria");
         menu = new JMenu[nombre.length];
         barra = new JMenuBar();
         
         for (int i = 0; i < nombre.length; i++) {
             menu[i] = new JMenu(nombre[i]);
             barra.add(menu[i]);
         }
         this.setJMenuBar(barra);
         
         //Productos
         prod= new Productos();
         
     }
    
}
