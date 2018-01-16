/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author angus
 */
public class Img extends JPanel{
    
    JLabel Jlaimg;
    Point op,lp=null,cp=null;
//    Dimension d;
    
    Status status;
    Img(String su) throws MalformedURLException{
    
        status = Status.Activated;
        
        URL url = new URL(su);
        ImageIcon imc = new ImageIcon(url);
        
        Jlaimg = new JLabel(imc);
        Jlaimg.setIcon(imc);
        Jlaimg.setBounds(0, 0, imc.getIconWidth(), imc.getIconHeight());
        this.add(Jlaimg);
        this.setSize( imc.getIconWidth(), imc.getIconHeight());
        
        
        
        this.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e){
                System.out.println("imgDragged:"+e.getXOnScreen() + "," + e.getYOnScreen());
                
                if (cp == null) {
                    cp = new Point();
                }
                // getXOnScreen() 與 getYOnScreen() 印出在螢幕中點擊的座標
                cp.x = e.getXOnScreen();
                cp.y = e.getYOnScreen();
                if (op == null) {
                    op = new Point();
                }
                op.x = op.x + (cp.x - lp.x);
                op.y = op.y + (cp.y - lp.y);
                Img.this.setLocation(op);
                lp.x = cp.x;
                lp.y = cp.y;
            }
        });
        
        
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("imgPressed");
                if (lp == null)
                    lp = new Point();
                lp.x = e.getXOnScreen();
                lp.y = e.getYOnScreen();
                op = Img.this.getLocation();
                
                
            }
            
            public void mouseReleased(MouseEvent e){
                System.out.println("mouse released in easyOBJ");
                
            }
            
            public void mouseEntered(MouseEvent e){
                
            }
            
            public void mouseExited(MouseEvent e){
                
            }
            
            
        });
    
    }
    
}
