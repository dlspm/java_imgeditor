/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.*;

/**
*
* @author seifer
*/
public class Rect extends easyOBJ{
    
    ImgPage parent;
    Point fp, cp;
    
    public Rect(ImgPage p, Point p1, Point p2){
        super(p, p1, p2.x-p1.x, p2.y-p1.y);
        fp = p1;
        cp = p2;
        parent = p;
    }
    
    protected Rectangle makeRect(Point p1, Point p2) {
        final int x = Math.min(p1.x, p2.x);
        final int y = Math.min(p1.y, p2.y);
        final int width = Math.abs(p1.x - p2.x);
        final int height = Math.abs(p1.y - p2.y);
        return new Rectangle(x, y, width, height);
    }
    
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.BLUE);
        System.out.println("Oval2" + parent.fp + "," + parent.cp);

        int w, h;
        w = (this.getSize()).width;
        h = (this.getSize()).height;
//      g.setColor(Color.black);
//      g.drawOval(0, 0, w-1, h-1);
        g2d.draw(makeRect(fp, cp));
//        parent.cp = null;
//        System.out.println("Oval3" + parent.fp + "," + parent.cp);

    }
}
