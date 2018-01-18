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
        
        System.out.println("add Img OK:" + imc.getIconWidth() + "," + imc.getIconHeight());
        
        Jlaimg = new JLabel();
        Jlaimg.setIcon(imc);
        Jlaimg.setBounds(20, 20, imc.getIconWidth(), imc.getIconHeight());
        Jlaimg.setSize(imc.getIconWidth(), imc.getIconHeight());
        this.add(Jlaimg);
        

        System.out.println(Jlaimg.getSize() + "," + Jlaimg.getLocation());
        this.setLocation(Jlaimg.getLocation());
        this.setSize(imc.getIconWidth(), imc.getIconHeight());
//        ep.activePage.picture(this);
//        ep.activePage.setOutline(Img.this);
//        p.repaint();
        
    }


//    Img(String su, EasyPainter ep) throws MalformedURLException{
//    
//        status = Status.Activated;
//        Point x , y;
////        URL url = new URL(su);
//        ImageIcon imc = new ImageIcon(su);
//        
//        System.out.println("add Img OK");
//        
//        Jlaimg = new JLabel(imc);
//        Jlaimg.setIcon(imc);
//        Jlaimg.setBounds(0, 0, imc.getIconWidth(), imc.getIconHeight());
//        this.add(Jlaimg);
//        this.setSize( imc.getIconWidth(), imc.getIconHeight());
//        x= this.getLocation();
//        this.setLocation(x);
//    }
    
    public Image reduceimg(ImageIcon icon ,String s){
        MediaTracker tracker = new MediaTracker(this);
        Image chImg = null;
        if(s == "變大"){
            chImg = icon.getImage().getScaledInstance(
                    (int) (icon.getIconWidth() * 1.2), -1, Image.SCALE_SMOOTH);
        }else if(s == "變小"){
            
            chImg = icon.getImage().getScaledInstance(
                    (int) (icon.getIconWidth() * 0.4), -1, Image.SCALE_SMOOTH);
        }
        
        return chImg;
    }
    
    
//    
//    public Img(ImgPage p) {
//        super(p);
//    }
//    
    
    
}
