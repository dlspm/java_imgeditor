/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author angus
 */
public class Text extends JTextPane{
//    JTextArea Jta=null;
    Point op,lp=null,cp=null;
    JTextArea txaDisplay = new JTextArea(10,10);
    
    Text(){
        
//        JTextArea txaDisplay = new JTextArea(10,10);
        SimpleAttributeSet attrSet = new SimpleAttributeSet();
        StyleConstants.setForeground(attrSet, Color.BLACK);
        insert("sssssss", attrSet);
//        JScrollPane scroll = new JScrollPane(txaDisplay);
//        //透明處理
//        scroll.setOpaque(false);
//        scroll.getViewport().setOpaque(false);
//        txaDisplay.setOpaque(false);
       
        setDocs("第一行的文字", Color.red, false, 20);
        this.setOpaque(false);
        
//        this.add(txaDisplay);

//        this.setBorder(txaDisplay);
//        this.setSize(100, 180);
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
    public void insert(String str, AttributeSet attrSet) {
        Document doc = this.getDocument();
        str = "\n" + str;
        try {
            doc.insertString(doc.getLength(), str, attrSet);
        } catch (BadLocationException e) {
            System.out.println("BadLocationException:   " + e);
        }

    }
    public void setDocs(String str, Color col, boolean bold, int fontSize) {
        SimpleAttributeSet attrSet = new SimpleAttributeSet();
        StyleConstants.setForeground(attrSet, col);
        //颜色     
        if (bold == true) {
            StyleConstants.setBold(attrSet, true);
        }//字体类型     
        StyleConstants.setFontSize(attrSet, fontSize);
        //字体大小     
        insert(str, attrSet);
    }
    
    
    
}
