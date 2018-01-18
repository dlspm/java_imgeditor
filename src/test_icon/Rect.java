/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author angus
 */
public class Rect extends easyOBJ{
    
    ImgPage parent;
    Point fp,cp;
    Color color;
    
    public Rect(ImgPage p, int x, int y, int w, int h, Color c){
        super(p, x, y, w, h, c);
    }
    public void paintComponentint(Graphics g)
    {
      int w,h;
      w = (this.getSize()).width;
      h = (this.getSize()).height;
       g.setColor(Rect.this.color);
      ((Graphics2D)g).setStroke(new BasicStroke(5));
      g.drawRect(0, 0, w-1, h-1);
    }
    
}