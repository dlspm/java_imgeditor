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
//    Img newOBJ = null;
    public Status status;
    
    public easyOBJ activeOBJ  = null;
    
    ImgPage() throws MalformedURLException{
        status = Status.Selection;
        this.setLayout(new FlowLayout());
        
        

        this.setSize(600,600);
    
    }
    
    void addOBJ(Img ip) {
        this.add(ip);
    }

    
}
