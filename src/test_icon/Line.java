/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.*;

/**
 *
 * @author angus
 */
public class Line {
    Point sp,ep;
    Color c;
    int font,w,h;
    public Line(Point s, Point e, Color a, int f) 
    {
        sp=s;
        ep=e;
        c=a;
        font=f;   
        
    }
    
    public Line(Point s, Point e) 
    {
        sp=s;
        ep=e;

        
    }
    
}
