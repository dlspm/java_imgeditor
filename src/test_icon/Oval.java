/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.*;
import java.awt.geom.Ellipse2D;
/**
 *
 * @author angus
 */
public class Oval extends easyOBJ {
    ImgPage parent;
    Point fp,cp;
    Color color;
//    public Oval(Page p, Point sp, int w, int h) {
    public Oval(ImgPage p, int x, int y, int w, int h, Color c) {
        super(p, x, y, w, h, c);
        color = c;
    }
        
    protected void paintComponent(Graphics g)
    {
        
        int w, h;
        w = (this.getSize()).width;
        h = (this.getSize()).height;
        g.setColor(color);
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.drawOval(0, 0, w - 1, h - 1);
        System.out.println("Opaint");

    }
    
}
