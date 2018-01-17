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
import javax.swing.JPanel;

/**
 *
 * @author angus
 */
public class easyOBJ extends JPanel {

    ImgPage parent;
//    SelectionOutline outline=null;
    Status status;
    Point op, lp = null, cp = null;
    Dimension d;

    easyOBJ(){ //沒有參數時只會有物件移動的功能
        
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
                System.out.println("imgPressed");
                if (lp == null)
                    lp = new Point();
                lp.x = e.getXOnScreen();
                lp.y = e.getYOnScreen();
                op = easyOBJ.this.getLocation();
                
                
            }
            
            public void mouseReleased(MouseEvent e){
                System.out.println("mouse released in easyOBJ");
                
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
                    }

                    // outline.setVisible(true);
                    status = Status.Activated;
                    parent.activeOBJ = easyOBJ.this;
                    parent.repaint();
                    System.out.println("1" + parent.activeOBJ.status);
                } else if (status == Status.Activated) {
                    System.out.println("2" + parent.activeOBJ.status);
                    if (lp == null) {
                        lp = new Point();
                    }
                    lp.x = e.getXOnScreen();
                    lp.y = e.getYOnScreen();
                    op = easyOBJ.this.getLocation();

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
