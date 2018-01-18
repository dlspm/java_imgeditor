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
    JButton Btnpen, Btnnewpage, Btnnewrect, Btnimg, Btntext, Btndow, Btnicon, Btnsele, Btndel;
    
    
    
    ToolBar(EasyPainter ep) throws MalformedURLException{
 
        this.setLayout(new GridLayout(9, 1));
        
        Btnpen = new JButton("Pen");
        Btnnewpage = new JButton("NewPage");
        Btnnewrect = new JButton("Rect");
        Btnimg = new JButton("Img");
        Btntext = new JButton("Text");
        Btndow = new JButton("Dow");
        Btnicon = new JButton("Icon");
        Btnsele = new JButton("Select");
        Btndel = new JButton("Delete");
        
//        Btnpen.addActionListener(this);
//        Btnnewpage.addActionListener(this);
//        Btnnewrect.addActionListener(this);
//        Btnimg.addActionListener(this);
        
        Btnpen.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e){
                
                if(ep.activePage!=null){
                    ep.parametersBar.status = Status.ToolBarPan;
                    ep.parametersBar.setToolBarPan();
                }
                System.out.println("success Pan");
            }
        });
        
        this.add(Btnpen);
        
        
        Btnnewpage.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked newPage");
                if (ep.activePage != null) {
                    ep.mainWin.remove(ep.activePage);
                }
                try {
                    ep.activePage = new ImgPage(ep);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ToolBar.class.getName()).log(Level.SEVERE, null, ex);
                }
                ep.pages.add(ep.activePage);
                ep.mainWin.setImgPage(ep.activePage);
                ep.curPages = ++ep.numPages;
                ep.megBar.updateInfo(ep.curPages, ep.numPages);
                //ep.mainWin.cpanel.revalidate();
                if(ep.activePage!=null){
                    ep.parametersBar.status = Status.ToolBarNewPage;
                    ep.parametersBar.setToolBarNewPage();
                }
                System.out.println("success newPage");
                
                
            }
        });
        this.add(Btnnewpage);
        
        
        Btnnewrect.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                
                if(ep.activePage!=null){
                    ep.parametersBar.status = Status.ToolBarRect;
                    ep.parametersBar.setToolBarRect();
                }
                System.out.println("success Rect");
            }
        });
        this.add(Btnnewrect);
        
        
        Btnimg.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                
                //                try {
//                    Img no = new Img("https://d2hsbzg80yxel6.cloudfront.net/images/69511/medium/16639037694fbdf3c729b5b.jpg");
//                    ep.activePage.addOBJ(no);
//                    ep.activePage.activeOBJ = no;
//                    
////                    ep.activePage.add(no);
//                  //  ep.activePage.revalidate();
//                    
//                    if(ep.activePage!=null){
//                        ep.parametersBar.status = Status.ToolBarImg;
//                        ep.parametersBar.setToolBarImg();
//                    }
//                    System.out.println("success Img");
//                    
//                } catch (MalformedURLException ex) {
//                    Logger.getLogger(ToolBar.class.getName()).log(Level.SEVERE, null, ex);
//                }


                //載入圖片
                if (ep.activePage.activeOBJ != null){
                    ep.activePage.activeOBJ =null;
                }
                
                Img no = null;
                try {
                    no = new Img("tt.jpg", ep);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ToolBar.class.getName()).log(Level.SEVERE, null, ex);
                }
                ep.activePage.addOBJ(no);
                ep.activePage.activeOBJ = no;
                ep.activePage.setOutline(no);
                
                
                ep.activePage.repaint();
                //                    ep.activePage.add(no);
                //  ep.activePage.revalidate();
                //                    if (ep.activePage != null) {
                //                        ep.parametersBar.status = Status.ToolBarImg;
                //                        ep.parametersBar.setToolBarImg();
                //                    }
                System.out.println("success Img");
            }
        });
        this.add(Btnimg);
        
        Btntext.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(ep.activePage!=null){
//                    Text t = new Text();
                    Text_easyOBJ t = new Text_easyOBJ();
                    ep.activePage.add(t);
                    ep.activePage.revalidate();

                    ep.parametersBar.status = Status.ToolBarText;
                    ep.parametersBar.setToolBarText();
                    
                    System.out.println("success Text");
                }
                
                
            }
        });
        this.add(Btntext);
        
        Btndow.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(ep.activePage!=null){
                    ep.parametersBar.status = Status.ToolBarDow;
                    ep.parametersBar.setToolBarDow();
                }
//                ep.activePage.revalidate();                
                System.out.println("success Dow");
                
            }
        });
        this.add(Btndow);
        
        Btnicon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                
                if(ep.activePage!=null){
                    ep.parametersBar.status = Status.ToolBarIcon;
                    ep.parametersBar.setToolBarIcon();
                    //                ep.activePage.revalidate();
                }
                System.out.println("success Icon");
                
            }
        });
        this.add(Btnicon);
        
        
        Btnsele.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(ep.activePage!=null){

                    ep.parametersBar.status = Status.ToolBarSele;
                    ep.parametersBar.setToolBarSele();
                }
                System.out.println("success Selected");

            }
        });
        this.add(Btnsele);
         
        Btndel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (ep.activePage != null) {

                    if (ep.activePage.activeOBJ != null) {
                        ep.activePage.remove(ep.activePage.activeOBJ);
                        ep.activePage.activeOBJ = null;
                        ep.activePage.repaint();
                    }
                    
                }
                System.out.println("success Selected");

            }
        });
        this.add(Btndel);
        
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
