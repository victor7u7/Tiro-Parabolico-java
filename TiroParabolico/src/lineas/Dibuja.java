package lineas;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.sin;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author israe
 */
public class Dibuja extends Canvas{
    public Dibuja (){}
    @Override
    public void paint(Graphics G){
    //numero de cuadros en x y en y NLX NLY
            int A;
        int NLX=4,NLY;
        
        A=1500/NLX;
        NLY=650/A;
        //cordenada del punto de origen
        int X0=50, Y0=250;
        
        G.setColor(Color.BLACK);
        
        for(int nlx=0; nlx<=NLX; nlx++){
            G.drawLine(X0+A*nlx, 900-Y0, X0+A*nlx, 50);    
        }
        
        for(int nly=0; nly<=NLY; nly++){
            G.drawLine(50,900-Y0-A*nly,1550,900-Y0-A*nly);    
        }
        
         
        //escala de la cuadricula 0.05 metros por cuadro
        float es, div=(float) 0.05;
        es=(float) (A/div);
        
        //tiro parabolico
        G.setColor(Color.RED);
        for(float t=0; t<=0.3; t+=0.0001){
            int gx = (int)(es*(1-Math.exp(-t)));
            int gy = (int)(es*(10.81*(1-Math.exp(-t))-9.81*t));
            G.drawLine(gx+X0, 900-Y0-gy, gx+X0+1, 900-Y0-gy+1);
                try {
                    //retardo de un miliseg
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Dibuja.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        //Calculo de posiciòn con un valor de tiempo dado T
       
        float T=(float) 0.01;
        //calculo del punto en un instante T
        float Xt,Yt;
        
        Xt= (float) (1-Math.exp(-T));
        Yt= (float) (10.81*(1-Math.exp(-T))-9.81*T);
        int gx = (int)(es*Xt);
        int gy = (int)(es*Yt);
        G.setColor(Color.BLUE);
        G.fillOval(gx+X0-10, 900-Y0-gy-10,20, 20);
        G.drawString("S("+Float.toString(Xt)+" ,"+Float.toString(Yt)+" ) cuando t = "+Float.toString(T), gx+X0-20, 900-Y0-gy-20);
        
   
    }
}
