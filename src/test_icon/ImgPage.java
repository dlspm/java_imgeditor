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
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
    
    EasyPainter p;
    public Vector<Line> lines = null;
    
    
    ImgPage(EasyPainter ep) throws MalformedURLException{
        
        p = ep;
        status = Status.Selection;
        
        cps = new ControlPoints(ImgPage.this);
        cps.setVisible(false);
        
        
        lines = new Vector<Line>();
        
       // this.setLayout(new FlowLayout());
        this.setLayout(null);
        this.addMouseListener(new MyMouseListener());
        this.addMouseMotionListener(new MyMouseMotionListener());

        this.setSize(600,600);
    
    }

//    ImgPage() {
//    }
    
    void Seledowimg(String path) throws Exception{
        
        // 要先改變狀態為 React
        //然後把畫出來的 code 寫在 mouseReleased 並判斷
        
        
//        Robot robot = new Robot();
////        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//        Dimension ps = this.getSize(); //取得 Panel 的 Size
//        Rectangle rect = new Rectangle(0, 0, ps.width, ps.height);
//        BufferedImage image = robot.createScreenCapture(rect);
//        ImageIO.write(image, "jpg", new File(path));
    }

    void Dowimg(String filename){
        FileOutputStream fos = null;
        try {
            System.out.println("變大");
            File f = new File("img/" + filename);
            exportOtherShapesImage(f, this);
//                Dowjpanel.this.exportOtherShapesImage("tt", jp3)

        } finally {
            
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(ImgPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public boolean exportOtherShapesImage(File f, JPanel panel) {
        Dimension imageSize = panel.getSize();
        BufferedImage image = new BufferedImage(imageSize.width,
                imageSize.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        panel.paint(g);
        g.dispose();
        try {
            ImageIO.write(image, "png", f);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    void addOBJ(Img ip) {
        this.add(ip);
    }
    void Loadimg(String path) throws MalformedURLException{
        System.out.println("Loadimg" + path);
        Img on = new Img(path, p);
        this.add(on);
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
        System.out.println("ImgPagepaintComponent");
        
       
        if(ImgPage.this.status == Status.ToolBarPan){
            for (int i = 0; i < this.lines.size(); i++) {
                Line l = this.lines.elementAt(i);
                g.drawLine(l.sp.x, l.sp.y, l.ep.x, l.ep.y);
            }

        }
        
        if(activeOBJ != null){
            if(activeOBJ.status == Status.Activated){
                Point p = activeOBJ.getLocation();
                Dimension d = activeOBJ.getSize();
                System.out.println("!paintComponent:" + p.x + "," + p.y + "," + d.width + "," + d.height);
                g.drawRect(p.x - 10, p.y - 10, d.width + 20, d.height + 20);
            }else{
                cps.setVisible(false);
            }
        }
    }
    
    public void setOutline(easyOBJ eo){
        System.out.println("setOutline");
        
        Graphics g = this.getGraphics();
        Point p = eo.getLocation();
        Dimension d = eo.getSize();
        System.out.println("paintComponent:" + p.x + "," + p.y + "," + d.width + "," + d.height);
        g.drawRect(p.x-10, p.y-10, d.width+20, d.height+20);
        this.repaint();
        cps.setLocations();
        cps.setVisible(true);
    }
    
    public void unsetOutline(easyOBJ eo){
        System.out.println("onsetOutline");
        
        Graphics g = ImgPage.this.getGraphics();
        Point p = eo.getLocation();
        Dimension d = eo.getSize();
        System.out.println("paintComponent:" + p.x + "," + p.y + "," + d.width + "," + d.height);
        g.drawRect(p.x-10, p.y-10, d.width+20, d.height+20);
        cps.setVisible(false);
    
    }
    

    class MyMouseMotionListener implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {
            System.out.print("mouse dragged:");
            System.out.println(fp+","+cp);

            if(ImgPage.this.status == Status.ToolBarPan){
                System.out.print("ToolBarPan");
                cp = e.getPoint();
                Graphics g = ImgPage.this.getGraphics();
                g.drawLine(lp.x, lp.y, cp.x, cp.y);
                ImgPage.this.lines.add(new Line(lp, cp));
                lp = cp;
            
            
            }else if(ImgPage.this.status == Status.ToolBarRect){
                System.out.print("ToolBarRect");
                System.out.println(fp + "," + cp);
                Graphics2D g2d = (Graphics2D) ImgPage.this.getGraphics();
                g2d.setXORMode(Color.red);
                g2d.setPaint(Color.BLUE);
                g2d.draw(makeOval(fp, cp));
            
            }
            
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
                    unsetOutline(activeOBJ);
                    ImgPage.this.activeOBJ = null;
//                    ImgPage.this.repaint();
//                    ImgPage.this.revalidate();
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("mouse released");
//            System.out.println(ImgPage.this.activeOBJ.status + "," + ImgPage.this.status);
            
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
//                    ImgPage.this.repaint();
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
//                    ImgPage.this.repaint();

//                        cp = e.getPoint();
//                        g2d.draw(makeOval(fp, cp));
//                        cp = null;  //畫出來 cp 是 null
                }
            }

//            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    
}
