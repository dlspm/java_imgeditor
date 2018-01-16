/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author angus
 */
//public class ToolBar extends JPanel implements ActionListener {
  public class ToolBar extends JPanel{  
    JButton Btnpen, Btnnewpage, Btnnewrect, Btnimg;
    
    
    
    ToolBar(EasyPainter ep) throws MalformedURLException{
 
        this.setLayout(new GridLayout(4, 1));
        
        Btnpen = new JButton("Pen");
        Btnnewpage = new JButton("NewPage");
        Btnnewrect = new JButton("Rect");
        Btnimg = new JButton("Img");
        
//        Btnpen.addActionListener(this);
//        Btnnewpage.addActionListener(this);
//        Btnnewrect.addActionListener(this);
//        Btnimg.addActionListener(this);
        
        Btnpen.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e){
                
                
            }
        });
        
        this.add(Btnpen);
        
        
        Btnnewpage.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    System.out.println("mouseClicked newPage");
                    if (ep.activePage != null) {
                        ep.mainWin.remove(ep.activePage);
                    }
                    
                    ep.activePage = new ImgPage();
                    ep.pages.add(ep.activePage);
                    
                    ep.mainWin.setImgPage(ep.activePage);
                    
                    ep.curPages = ++ep.numPages;
                    ep.megBar.updateInfo(ep.curPages, ep.numPages);
                    ep.mainWin.cpanel.revalidate();
                    
                    System.out.println("success newPage");
                    
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ToolBar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });
        this.add(Btnnewpage);
        
        
        Btnnewrect.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

            }
        });
        this.add(Btnnewrect);
        
        
        Btnimg.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                
                try {
                    Img no = new Img("https://d2hsbzg80yxel6.cloudfront.net/images/69511/medium/16639037694fbdf3c729b5b.jpg");
                    ep.activePage.addOBJ(no);
//                    ep.activePage.add(no);
                    ep.activePage.revalidate();
                    
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ToolBar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.add(Btnimg);
        
        this.setSize(100,600);
        
    }
    
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//    
}
