/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.Point;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author angus
 */
public class Text extends easyOBJ{
//    JTextArea Jta=null;
    Point op,lp=null,cp=null;
    
    Text(){
        
        JTextArea txaDisplay = new JTextArea(10,10);

//        JScrollPane scroll = new JScrollPane(txaDisplay);
//        //透明處理
//        scroll.setOpaque(false);
//        scroll.getViewport().setOpaque(false);
//        txaDisplay.setOpaque(false);
        this.add(txaDisplay);

//        TitledBorder nameTitle = new TitledBorder("FileName List");


//        this.setBorder(txaDisplay);
//        this.setSize(100, 180);
    
    }
    
    
    
}
