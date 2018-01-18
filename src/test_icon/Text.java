/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author angus
 */
public class Text extends easyOBJ{
//    JTextArea Jta=null;
    Point op,lp=null,cp=null;
    JLabel Jlatext;
    
    Text(String st, EasyPainter ep){
        
        this.setOpaque(false);
        this.setLocation(10, 10);
//        this.add(txaDisplay);

//        this.setBorder(txaDisplay);
//        this.setSize(100, 180);
        
        Jlatext = new JLabel(st, JLabel.CENTER);
        Jlatext.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 48));
        final JColorChooser colorChooser = new JColorChooser(Jlatext.getBackground());

        ColorSelectionModel model = colorChooser.getSelectionModel();
        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                Color newForegroundColor = colorChooser.getColor();
                Jlatext.setForeground(newForegroundColor);
            }
        };
        model.addChangeListener(changeListener);

        ep.mainWin.cpanel.add(colorChooser, BorderLayout.CENTER);
//        frame.add(colorChooser, BorderLayout.CENTER);
    

        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                System.out.println("imgDragged:" + e.getXOnScreen() + "," + e.getYOnScreen());

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
                Text.this.setLocation(op);
                lp.x = cp.x;
                lp.y = cp.y;
            }
        });

        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("imgPressed");
                if (lp == null) {
                    lp = new Point();
                }
                lp.x = e.getXOnScreen();
                lp.y = e.getYOnScreen();
                op = Text.this.getLocation();

            }

            public void mouseReleased(MouseEvent e) {
                System.out.println("mouse released in easyOBJ");

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }

        });
    
    }
    
}
