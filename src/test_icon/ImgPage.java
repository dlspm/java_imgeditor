/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author angus
 */
public class ImgPage extends JPanel{
    
    JLabel tt;
//    Img newOBJ = null;
    public Status status;
    public easyOBJ activeOBJ=null;
    
    Point lp, cp, fp;
    
    public Vector<Rect> rects = null;
    
    
    ImgPage(EasyPainter ep) throws MalformedURLException{
        status = Status.Selection;
        this.setLayout(new FlowLayout());
        
        
        status = Status.Selection;
        
//        cps = new ControlPoints(Page.this);
        
        
        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                
            }
        });
        
        
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            
                System.out.println("mouse pressed");
//                if (ImgPage.this.status == Status.Drawing) {
//                    fp = e.getPoint(); //為了之後畫框
//                    lp = e.getPoint();
//                } else if (ImgPage.this.status == Status.CreatingOBJ || ImgPage.this.status == Status.EllipseOBJ) {
//                    fp = e.getPoint();
//                    cp = null;
//                }
//
//                if (ImgPage.this.activeOBJ != null) //當繪製完成後在 Page 上點擊空白部分
//                {
//                    System.out.println("here");
//                    if (ImgPage.this.activeOBJ.status == Status.Activated) {
//                        //Page.this.activeOBJ.outline.setVisible(false);
//                        ImgPage.this.activeOBJ.status = Status.Inactivated;
//                        ImgPage.this.activeOBJ = null;
//                        ImgPage.this.repaint();
//                        ImgPage.this.revalidate();
//                    }
//                }
                
            }
            
            public void mouseReleased(MouseEvent e){
                System.out.println("mouse released");

//                System.out.println(ImgPage.this.status);
//
//                Graphics g = ImgPage.this.getGraphics();
//                final Graphics2D g2d = (Graphics2D) g;
//                g2d.setPaint(Color.BLUE);
//
//                if (cp != null) {
//                    System.out.println(1);
//
////                    g2d.draw(makeRect(fp, cp));
//                }
//                if (cp != null) {
//                    System.out.println(2);
//
//                    if (ImgPage.this.status == Status.Drawing) {
//                        System.out.println(fp + "," + lp);
////                        g.drawRect(fp.x, fp.y, cp.x - fp.x, cp.y -fp.y);
////                        DrawLine newLine = new DrawLine(Page.this, fp, cp);
//
////                        Page.this.add(newLine);
////                        Page.this.activeOBJ = newLine;
//                        ImgPage.this.repaint();
//                    }
//                    if (ImgPage.this.status == Status.CreatingOBJ) {
//                        cp = e.getPoint();
////                    shapeList.add(makeRect(begin, end));
//                        ImgPage.this.rects.add(new Rect(fp, cp));
//                        fp = cp = null;
////                    repaint();
//                    }
//                    if (ImgPage.this.status == Status.EllipseOBJ) {
////                        cp = e.getPoint();
////                     shapeList.add(makeRect(begin, end));
////                        Page.this.ovals.add(new Rect(begin, end));
//
//                        System.out.println("Released" + fp + "," + cp);
////                        Oval newOBJ = new Oval(Page.this, fp, cp.x-fp.x, cp.y-fp.y );
//
//                        Img nO = null;
//                        try {
//                            nO = new Img("https://d2hsbzg80yxel6.cloudfront.net/images/69511/medium/16639037694fbdf3c729b5b.jpg");
//                        } catch (MalformedURLException ex) {
//                            Logger.getLogger(ImgPage.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        ImgPage.this.add(nO);
//                        ImgPage.this.activeOBJ = nO;
//                        ImgPage.this.repaint();
//
////                        cp = e.getPoint();
////                        g2d.draw(makeOval(fp, cp));
////                        cp = null;  //畫出來 cp 是 null
//                    }
//                }
//
//                repaint();
            }
        });
        
        
        
        
        
        
//        URL url = new URL("https://d2hsbzg80yxel6.cloudfront.net/images/69511/medium/16639037694fbdf3c729b5b.jpg");
//        ImageIcon imc = new ImageIcon(url);
////        Image smallImg = (Image)imc;
////        ImageIcon smallIcon = new ImageIcon(imc);
//        tt = new JLabel(imc);
//        tt.setIcon(imc);
//        tt.setBounds(0, 0, imc.getIconWidth(), imc.getIconHeight());
        
        
        Img newOBJ = new Img("https://d2hsbzg80yxel6.cloudfront.net/images/69511/medium/16639037694fbdf3c729b5b.jpg");
        this.add(newOBJ);
        
        this.setSize(600,600);
    
    }

    
}
