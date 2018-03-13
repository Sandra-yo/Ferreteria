/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebaProductos;

import Interfaces.Central;
import Interfaces.Productos;
import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author Aldair
 */
public class TestProducto {
    public static void main(String[] args) {
        Central n= new Central();
        n.setExtendedState(JFrame.MAXIMIZED_BOTH);
        n.setVisible(true);
        n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
