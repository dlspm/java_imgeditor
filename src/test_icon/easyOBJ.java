/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class easyOBJ extends JPanel {

    
    
    
//    EasyPainter ep;
    ImgPage parent;
//    SelectionOutline outline=null;
    Status status;
    Point op, lp = null, cp = null;
    Dimension d;
    Img easyOBJimg = null;  //為了要拿到 ImageIcon 物件, Jlabel
//    JLabel imglabel = null;
    
    
    easyOBJ(EasyPainter p){ //Img
        
        parent = p.activePage;
        status = Status.Activated;
        
        this.addMouseMotionListener(new MouseAdapter(){ 
            public void mouseDragged(MouseEvent e){
                System.out.println("imgDragged:"+e.getXOnScreen() + "," + e.getYOnScreen());
                
                if (cp == null) {
                    cp = new Point();
                }
                // getXOnScreen() 與 getYOnScreen() 印出在螢幕中點擊的座標
                cp.x = e.getXOnScreen();
                cp.y = e.getYOnScreen();
                if (op == null) {
                    op = new Point();
                }
                op.x = op.x + (cp.x - lp.x);
                op.y = op.y + (cp.y - lp.y);
                easyOBJ.this.setLocation(op);
                lp.x = cp.x;
                lp.y = cp.y;
            }
        });
        
        
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("imgPressed_ep:" + status);
                if (status == Status.Inactivated) {

                    if (parent.activeOBJ != null) {
                        System.out.println("1" + parent.activeOBJ.status);
                        //  parent.activeOBJ.outline.setVisible(false);
                        
//                        parent.onsetOutline(easyOBJ.this);
                        parent.activeOBJ.status = Status.Inactivated;
                        parent.activeOBJ = null;
                    }

                    // outline.setVisible(true);
                    status = Status.Activated;
                    parent.activeOBJ = easyOBJ.this;
                    parent.activeOBJ.status = Status.Activated;//從新指定新的物件並畫出外框
//                    parent.repaint();
                    System.out.println("1" + parent.activeOBJ.status);
                }else if(status==Status.Activated){
    //                ImgPage.this.activeOBJ.status
                    System.out.println("2" + parent.status + "," + status);
                    parent.unsetOutline(easyOBJ.this);
                    if (lp == null)
                        lp = new Point();
                    lp.x = e.getXOnScreen();
                    lp.y = e.getYOnScreen();
                    op = easyOBJ.this.getLocation();
                    
                    parent.status = Status.MovingOBJ;
                    status = Status.Moving;
                    System.out.println("2" + parent.status + "," + status);
                }
                
            }
            
            public void mouseReleased(MouseEvent e){
                System.out.println("mouse released in easyOBJ");
                
                parent.status = Status.Selection;
                status = Status.Activated;
                
                
                System.out.println("3" + parent.status + "," + status);
                
                parent.setOutline(easyOBJ.this);
            }
            
            public void mouseEntered(MouseEvent e){
                
            }
            
            public void mouseExited(MouseEvent e){
                
            }
            
            
        });

    }
    
    easyOBJ(){
//        parent = ep.activePage;
        status = Status.Activated;
        
        this.addMouseMotionListener(new MouseAdapter(){ 
            public void mouseDragged(MouseEvent e){
                System.out.println("imgDragged:"+e.getXOnScreen() + "," + e.getYOnScreen());
                
                if (cp == null) {
                    cp = new Point();
                }
                // getXOnScreen() 與 getYOnScreen() 印出在螢幕中點擊的座標
                cp.x = e.getXOnScreen();
                cp.y = e.getYOnScreen();
                if (op == null) {
                    op = new Point();
                }
                op.x = op.x + (cp.x - lp.x);
                op.y = op.y + (cp.y - lp.y);
                easyOBJ.this.setLocation(op);
                lp.x = cp.x;
                lp.y = cp.y;
            }
        });
        
        
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("imgPressed_ep:" + status);
                if (status == Status.Inactivated) {

                    if (parent.activeOBJ != null) {
                        System.out.println("1" + parent.activeOBJ.status);
                        //  parent.activeOBJ.outline.setVisible(false);
                        
//                        parent.onsetOutline(easyOBJ.this);
                        parent.activeOBJ.status = Status.Inactivated;
                        parent.unsetOutline(easyOBJ.this);
                        parent.activeOBJ = null;
                    }

                    // outline.setVisible(true);
                    status = Status.Activated;
                    parent.activeOBJ = easyOBJ.this;
                    parent.activeOBJ.status = Status.Activated;//從新指定新的物件並畫出外框
//                    parent.repaint();
                    System.out.println("1" + parent.activeOBJ.status);
                }else if(status==Status.Activated){
    //                ImgPage.this.activeOBJ.status
                    System.out.println("2" + parent.status + "," + status);
                    parent.unsetOutline(easyOBJ.this);
                    if (lp == null)
                        lp = new Point();
                    lp.x = e.getXOnScreen();
                    lp.y = e.getYOnScreen();
                    op = easyOBJ.this.getLocation();
                    
                    parent.status = Status.MovingOBJ;
                    status = Status.Moving;
                    System.out.println("2" + parent.status + "," + status);
                }
                
            }
            
            public void mouseReleased(MouseEvent e){
                System.out.println("mouse released in easyOBJ");
                
                parent.status = Status.Selection;
                status = Status.Activated;
                
                
                System.out.println("3" + parent.status + "," + status);
                
                parent.setOutline(easyOBJ.this);
            }
            
            public void mouseEntered(MouseEvent e){
                
            }
            
            public void mouseExited(MouseEvent e){
                
            }
            
            
        });
        
    }
    

    easyOBJ(ImgPage p, Point sp, int w, int h) {
        super();
        status = Status.Activated;
        parent = p;
        this.setSize(w, h);
        this.setLocation(sp);

        // this.setBackground(Color.red);
        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                System.out.println("easD" + parent.activeOBJ.status);
                System.out.println("easD" + status);
                if (cp == null) {
                    cp = new Point();
                }
                // getXOnScreen() 與 getYOnScreen() 印出在螢幕中點擊的座標
                cp.x = e.getXOnScreen();
                cp.y = e.getYOnScreen();
                if (op == null) {
                    op = new Point();
                }
                op.x = op.x + (cp.x - lp.x);
                op.y = op.y + (cp.y - lp.y);
                easyOBJ.this.setLocation(op);
                lp.x = cp.x;
                lp.y = cp.y;

            }
        });
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("mouse pressed in easyOBJ");
                if (status == Status.Inactivated) {
                    if (parent.activeOBJ != null) {
                        //  parent.activeOBJ.outline.setVisible(false);
                        parent.activeOBJ.status = Status.Inactivated;
                        parent.activeOBJ = null;
                    }

                    // outline.setVisible(true);
                    status = Status.Activated;
                    parent.activeOBJ = easyOBJ.this;
                    parent.cps.setLocations();
//                    parent.repaint();
                    System.out.println("1" + parent.activeOBJ.status);
                } else if (status == Status.Activated) {
                    System.out.println("2" + parent.activeOBJ.status);
                    if (lp == null) {
                        lp = new Point();
                    }
                    lp.x = e.getXOnScreen();
                    lp.y = e.getYOnScreen();
                    op = easyOBJ.this.getLocation();
                    parent.activeOBJ = easyOBJ.this;
                    parent.status = Status.MovingOBJ;
                    status = Status.Moving;
                    //setVisible(false);
                    System.out.println("2" + parent.activeOBJ.status);
                }
            }

            public void mouseReleased(MouseEvent e) {
                System.out.println("mouse released in easyOBJ");
                if (status == Status.Moving) {

                    status = Status.Activated;
                }
            }
        });

    }
}