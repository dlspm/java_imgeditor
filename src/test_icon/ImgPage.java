/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author angus
 */
public class ImgPage extends JPanel{
    
    JLabel tt;
    Img newOBJ = null;
    public Status status;
    
    ImgPage(EasyPainter ep) throws MalformedURLException{
        status = Status.Selection;
        this.setLayout(new FlowLayout());
        
        
        
//        URL url = new URL("https://d2hsbzg80yxel6.cloudfront.net/images/69511/medium/16639037694fbdf3c729b5b.jpg");
//        ImageIcon imc = new ImageIcon(url);
////        Image smallImg = (Image)imc;
////        ImageIcon smallIcon = new ImageIcon(imc);
//        tt = new JLabel(imc);
//        tt.setIcon(imc);
//        tt.setBounds(0, 0, imc.getIconWidth(), imc.getIconHeight());
        
        
        newOBJ = new Img("https://d2hsbzg80yxel6.cloudfront.net/images/69511/medium/16639037694fbdf3c729b5b.jpg");
        this.add(newOBJ);
        
        this.setSize(600,600);
    
    }

    
}
