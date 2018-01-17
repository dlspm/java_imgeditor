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
public class Img extends easyOBJ{
    
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
        
        
    
    }
    
}
