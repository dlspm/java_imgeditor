/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.w3c.dom.css.Rect;

/**
 *
 * @author angus
 */
public class ImgPage extends JPanel{
    
    JLabel tt;
//    Img newOBJ = null;
    public Status status;
    
    public easyOBJ activeOBJ  = null;
    ControlPoints cps;
    Point lp, cp, fp;
    
    
    public Vector<Line> lines = null;
    
    
    ImgPage() throws MalformedURLException{
        status = Status.Selection;
        
        cps = new ControlPoints(ImgPage.this);
        
        
        lines = new Vector<Line>();
        
       // this.setLayout(new FlowLayout());
        this.setLayout(null);
        this.addMouseListener(new MyMouseListener());
        this.addMouseMotionListener(new MyMouseMotionListener());

        this.setSize(600,600);
    
    }

    
    void addOBJ(Img ip) {
        this.add(ip);
    }
    void Loadimg(String path) throws MalformedURLException{
        System.out.println("Loadimg" + path);
        Img on = new Img(path);
        this.add(on);
//        try {
//            Img on = new Img(path);
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(ImgPage.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    protected Rectangle makeRect(Point p1, Point p2) {
        final int x = Math.min(p1.x, p2.x);
        final int y = Math.min(p1.y, p2.y);
        final int width = Math.abs(p1.x - p2.x);
        final int height = Math.abs(p1.y - p2.y);
        return new Rectangle(x, y, width, height);
    }

    protected Ellipse2D.Double makeOval(Point p1, Point p2) {
        final int x = Math.min(p1.x, p2.x);
        final int y = Math.min(p1.y, p2.y);
        final int width = Math.abs(p1.x - p2.x);
        final int height = Math.abs(p1.y - p2.y);
        return new Ellipse2D.Double(x, y, width, height);
    }
    
    protected void paintComponent(Graphics g) {
        System.out.println("重劃拉幹 幹！");
        
        if(this.activeOBJ != null){
            System.out.println("有物件拉 幹！");
//            super.paintComponent(g);
            Point p = activeOBJ.getLocation();
            Dimension d = activeOBJ.getSize();
            System.out.println("paintComponent:" + p.x + "," + p.y + "," + d.width + "," + d.height);
            g.drawRect(p.x - 5, p.y - 5, d.width + 10, d.height + 10);
            cps.setLocations();
            cps.setVisible(true);
        }else {
            cps.setVisible(false);
        }
    }
    
    class MyMouseMotionListener implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {
            System.out.print("mouse dragged:");
            System.out.println(fp+","+cp);

            if(ImgPage.this.status == Status.ToolBarPan){
                cp = e.getPoint();
                Graphics g = ImgPage.this.getGraphics();
                g.drawLine(lp.x, lp.y, cp.x, cp.y);
                ImgPage.this.lines.add(new Line(lp, cp));
                lp = cp;
            
            
            }else if(ImgPage.this.status == Status.ToolBarRect){
                System.out.println(fp + "," + cp);
                Graphics2D g2d = (Graphics2D) ImgPage.this.getGraphics();
                g2d.setXORMode(Color.red);
                g2d.setPaint(Color.BLUE);
                if (cp != null) { // 覆蓋過原本
//                        g2d.setPaint(Page.this.getBackground());
//                        g2d.draw(makeOval(fp, cp));
                }
//                    g2d.setPaint(Color.BLUE);
                cp = e.getPoint();
                g2d.draw(makeOval(fp, cp));
            
            }
            
            
//            Point p = activeOBJ.getLocation();
//            Dimension d = activeOBJ.getSize();
//            System.out.println("paintComponent:" + p.x + "," + p.y + "," + d.width + "," + d.height);
//            Graphics g = ImgPage.this.getGraphics();
            
//            Graphics2D g2d = (Graphics2D) ImgPage.this.getGraphics();
//            g2d.setXORMode(Color.red);
//            g2d.setPaint(Color.BLUE);
//            if (cp != null) { // 覆蓋過原本
//                g.drawRect(p.x - 5, p.y - 5, d.width + 10, d.height + 10);
//            }
//            cp = e.getPoint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    
    
    }
    
    class MyMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("mouseClicked");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
            System.out.println("mouse pressed");
            
            if(status == Status.ToolBarPan){
                fp = e.getPoint(); //為了之後畫框
                lp = e.getPoint();
            
            
            }else if(status == Status.ToolBarRect){
                fp = e.getPoint();
                cp = null;
            }
            
            if (ImgPage.this.activeOBJ != null) //當繪製完成後在 Page 上點擊空白部分
            {
                System.out.println("here");
                System.out.println(ImgPage.this.activeOBJ.status + "," + ImgPage.this.status);
            
                if (ImgPage.this.activeOBJ.status == Status.Activated) {
                    //Page.this.activeOBJ.outline.setVisible(false);
                    ImgPage.this.activeOBJ.status = Status.Inactivated;
                    ImgPage.this.activeOBJ = null;
                    ImgPage.this.repaint();
//                    ImgPage.this.revalidate();
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("mouse released");
            System.out.println(ImgPage.this.activeOBJ.status + "," + ImgPage.this.status);
            
            Graphics g = ImgPage.this.getGraphics();
            final Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(Color.BLUE);

            if (cp != null) {
                System.out.println(1);

//                    g2d.draw(makeRect(fp, cp));
            }
            if (cp != null) {
                System.out.println(2);

                if (ImgPage.this.status == Status.ToolBarPan) {
                    System.out.println(fp + "," + lp);
//                        g.drawRect(fp.x, fp.y, cp.x - fp.x, cp.y -fp.y);
//                        DrawLine newLine = new DrawLine(Page.this, fp, cp);

//                        Page.this.add(newLine);
//                        Page.this.activeOBJ = newLine;
                    ImgPage.this.repaint();
                }
                if (ImgPage.this.status == Status.ToolBarRect) {
                    cp = e.getPoint();
//                    shapeList.add(makeRect(begin, end));
//                    ImgPage.this.rects.add(new Rect(fp, cp));
                    fp = cp = null;
//                    repaint();
                }
                if (ImgPage.this.status == Status.EllipseOBJ) {
//                        cp = e.getPoint();
//                     shapeList.add(makeRect(begin, end));
//                        Page.this.ovals.add(new Rect(begin, end));

                    System.out.println("Released" + fp + "," + cp);
//                        Oval newOBJ = new Oval(Page.this, fp, cp.x-fp.x, cp.y-fp.y );

                    Oval newOBJ = new Oval(ImgPage.this, fp, cp);
                    ImgPage.this.add(newOBJ);
                    ImgPage.this.activeOBJ = newOBJ;
                    ImgPage.this.repaint();

//                        cp = e.getPoint();
//                        g2d.draw(makeOval(fp, cp));
//                        cp = null;  //畫出來 cp 是 null
                }
            }

            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    
}
