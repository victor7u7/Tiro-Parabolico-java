/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineas;
import javax.swing.JFrame;

/**
 *
 * @author israe
 */
public class Lienzo extends JFrame{
    public Lienzo(){
        setVisible(true);
        setSize(1000,1000);
        add (new Dibuja());
    }

    }
