/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
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
    
    
    
//    Img newOBJ = null;
    public Status status;
    
    public easyOBJ activeOBJ  = null;
    ControlPoints cps;
    Point lp, cp, fp;
    
    EasyPainter p;
    public Vector<Line> lines = null;
    
    Img activeimg = null;
    public Color color = Color.BLACK;
    public int linesize = 1;
    
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
    
    public void reduceimg(ImageIcon icon, String s) {
        

        MediaTracker tracker = new MediaTracker(this);
        Image chImg = null;
        ImageIcon ch = null;
        System.out.println("reduceimg:" + s);
        if(activeOBJ.easyOBJimg != null){
            
//            this.unsetOutline(activeOBJ);
            System.out.println("!activeimg!:" + activeimg.getLocation().x + "," + activeimg.getLocation().y + "," + activeOBJ.getSize().width + "," + activeOBJ.getSize().height);
            int width = activeOBJ.easyOBJimg.imc.getIconWidth();// your prefered width
            int height = activeOBJ.easyOBJimg.imc.getIconHeight();//your prefered height

            ImageIcon image= activeOBJ.easyOBJimg.imc;
            //方法 1
//            image.setImage(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
            JLabel jLab1 = new JLabel(image);
            System.out.println("reduceimg:" + width + "," + height);
            if (s == "變大") {
                width *= 1.3;
                height *= 1.3;
                
            }else if(s == "變小"){
                width /= 1.3;
                height /= 1.3;
            }
            
            image.setImage(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
            activeimg.Jlaimg.setIcon(image);
//            activeimg.setLocation(activeimg.Jlaimg.getLocation());
//            activeimg.setSize(width, height);
            System.out.println("!activeOBJ!:" + activeOBJ.getLocation().x + "," + activeOBJ.getLocation().y + "," + activeOBJ.getSize().width + "," + activeOBJ.getSize().height);
            activeOBJ = activeimg;
//            activeOBJ.setLocation(activeimg.Jlaimg.getLocation());
//            activeOBJ.setSize(activeimg.Jlaimg.getSize());
            System.out.println("reduceimg:activeimg" + activeimg.getSize().width + activeimg.getSize().height );
            this.setOutline(activeOBJ);
            repaint();
            
        }

        activeimg.Jlaimg.setIcon(icon);
        
    }
    
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
            System.out.println("全部");
            File f = new File("img/" + filename);
//            File f = new File("img/i.jpg");
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
        
            g.setColor(color);
//        if(p.parametersBar.status == Status.ToolBarPan){
            for (int i = 0; i < this.lines.size(); i++) {
                Line l = this.lines.elementAt(i);
                g.drawLine(l.sp.x, l.sp.y, l.ep.x, l.ep.y);
            }

//        }
        
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
        System.out.println("unsetOutline");
        
        Graphics g = ImgPage.this.getGraphics();
        Point p = eo.getLocation();
        Dimension d = eo.getSize();
        System.out.println("paintComponent:" + p.x + "," + p.y + "," + d.width + "," + d.height);
        g.drawRect(p.x-10, p.y-10, d.width+20, d.height+20);
        cps.setVisible(false);
    
    }
    
    public void quadrant(Graphics g) {
        if (((cp.x - fp.x) > 0) && ((fp.y - cp.y) > 0)) {                     //第1象限
            g.drawRect(fp.x, cp.y, cp.x - fp.x, fp.y - cp.y);
        } else if (((fp.x - cp.x) > 0) && ((fp.y - cp.y) > 0)) {                //第2象限
            g.drawRect(cp.x, cp.y, fp.x - cp.x, fp.y - cp.y);
        } else if (((fp.x - cp.x) > 0) && ((cp.y - fp.y) > 0)) {                //第3象限
            g.drawRect(cp.x, fp.y, fp.x - cp.x, cp.y - fp.y);
        } else if (((cp.x - fp.x) > 0) && ((cp.y - fp.y) > 0)) {                //第4象限
            g.drawRect(fp.x, fp.y, cp.x - fp.x, cp.y - fp.y);
        }
    }
    
//    public easyOBJ object(ImgPage p, int x, int y, int w, int h, Color c) {
//        easyOBJ newOBJ = null;
//
//        if (ImgPage.this.p.parametersBar.status == Status.ToolBarRect) {
//            newOBJ = new Oval(p, x, y, w, h, color);
//            System.out.println("Rect");
////        } else if (p.parametersBar.status == Status.ToolBarRect) {
////            newOBJ = new Oval(p, x, y, w, h, c, num++);
////            System.out.println("Oval");
//        } else if (ImgPage.this.p.parametersBar.status == Status.ToolBarOval) {
//            newOBJ = new Oval(p, x, y, w, h, color);
//            System.out.println("diamond");
//        }
//
//        return newOBJ;
//    }

    class MyMouseMotionListener implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {
            System.out.print("mouse dragged:" + p.parametersBar.status);
            System.out.println(fp+","+cp);

            if(p.parametersBar.status == Status.ToolBarPan){
                
                cp = e.getPoint();
                Graphics g = ImgPage.this.getGraphics();
                g.setColor(color);
                g.drawLine(lp.x, lp.y, cp.x, cp.y);
                ImgPage.this.lines.add(new Line(lp, cp));
                lp = cp;
            
            
            }else if(p.parametersBar.status == Status.ToolBarRect){
                
                System.out.println(fp + "," + cp);
                
                Graphics2D g2d = (Graphics2D) ImgPage.this.getGraphics();
                g2d.setXORMode(Color.red);
                g2d.setPaint(Color.BLUE);
                if (cp != null) { // 覆蓋過原本
//                        g2d.setPaint(Page.this.getBackground());
                        g2d.draw(makeOval(fp, cp));
                }
//                    g2d.setPaint(Color.BLUE);
                cp = e.getPoint();
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
            
            System.out.println("mouse pressed" + p.parametersBar.status);
            
            if(p.parametersBar.status == Status.ToolBarPan){
//                fp = e.getPoint(); //為了之後畫框
                lp = e.getPoint();
            
            
            }else if(p.parametersBar.status == Status.ToolBarRect){
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
//            g2d.setPaint(Color.BLUE);
             g2d.setStroke(new BasicStroke(1.0f));  
             g2d.setXORMode(Color.red);
            g.setXORMode(Color.red);



            
            if (cp != null) {
                System.out.println(1);
//                    g2d.draw(makeRect(fp, cp));
            }
            if (cp != null) {
                System.out.println(2);

                if (p.parametersBar.status == Status.ToolBarPan) {
                    System.out.println(fp + "," + lp);
                }
                if (p.parametersBar.status == Status.ToolBarRect) {
                    
                    System.out.println("Released" + fp + "," + cp);
                    

                    
//                    Rect newOBJ = new ;
                    Oval newOBJ = null ;
//                    g2d.draw(makeOval(fp, cp));
                    
                    if (((cp.x - fp.x) > 0) && ((fp.y - cp.y) > 0)) {                     //第1象限
                        
                        newOBJ = new Oval(ImgPage.this, fp.x, cp.y, cp.x - fp.x, fp.y - cp.y, color);
                    } else if (((fp.x - cp.x) > 0) && ((fp.y - cp.y) > 0)) {                //第2象限
                        
                        newOBJ = new Oval(ImgPage.this, cp.x, cp.y, fp.x-cp.x, fp.y-cp.y, color);
                    } else if (((fp.x - cp.x) > 0) && ((cp.y - fp.y) > 0)) {                //第3象限
                        
                        newOBJ = new Oval(ImgPage.this, cp.x, fp.y, fp.x-cp.x, cp.y-fp.y, color);
                    } else if (((cp.x - fp.x) > 0) && ((cp.y - fp.y) > 0)) {                //第4象限
                        
                        newOBJ = new Oval(ImgPage.this, fp.x, fp.y, cp.x-fp.x, cp.y-fp.y, color);
                    }

                    ImgPage.this.add(newOBJ);
                    activeOBJ = newOBJ;
                    ImgPage.this.setOutline(activeOBJ);
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
