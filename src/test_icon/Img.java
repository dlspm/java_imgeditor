/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author angus
 */
public class Img extends easyOBJ{
    
    JLabel Jlaimg;
    Point op,lp=null,cp=null;
    Dimension d;
    
    Status status;
    ImageIcon imc;
    Img(String su, EasyPainter ep) throws MalformedURLException{
        super(ep);
        status = Status.Activated;
        Point x , y;
//        URL url = new URL(su);
        imc = new ImageIcon(su);
        this.setLocation(ep.activePage.getLocation().x+50,ep.activePage.getLocation().y+50 );
        
        System.out.println("add Img OK:" + imc.getIconWidth() + "," + imc.getIconHeight());
        
        Jlaimg = new JLabel();
        Jlaimg.setIcon(imc);
        //Jlaimg.setBounds(20, 20, imc.getIconWidth(), imc.getIconHeight());
        Jlaimg.setSize(imc.getIconWidth(), imc.getIconHeight());
        this.add(Jlaimg);
        

        System.out.println(Jlaimg.getSize() + "," + Jlaimg.getLocation());
       // this.setLocation(Jlaimg.getLocation());
        this.setSize(imc.getIconWidth(), imc.getIconHeight());
        
        
    }
    
}
