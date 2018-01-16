/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

/**
 *
 * @author angus
 */
//public class ParametersBar extends JPanel implements FocusListener{
  public class ParametersBar extends JPanel{  
    JTextField Jtfsize, Jtfcolor, Jtfline;
    
    ParametersBar(EasyPainter ep){
        this.setLayout(new GridLayout(4, 1));

        Jtfsize = new JTextField(7);
        Jtfcolor = new JTextField(7);
        Jtfline = new JTextField(7);
        
//        Jtfsize.addFocusListener(this);
//        Jtfcolor.addFocusListener(this);
//        Jtfline.addFocusListener(this);
        

        this.add(Jtfsize);
        this.add(Jtfcolor);
        this.add(Jtfline);

        this.setSize(100, 600);
    
    }

//    @Override
//    public void focusGained(FocusEvent e) {
//        
//        
////        if(e.getSource() == Jtfsize){
////            Jtfsize.setText("");
////        }else if(e.getSource() == Jtfcolor){
////            Jtfcolor.setText("");
////        }else if(e.getSource() == Jtfline){
////            Jtfline.setText("");
////        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void focusLost(FocusEvent e) {
//        
//        
////        if (e.getSource() == Jtfsize) {
////            if(Jtfsize.getText() == ""){
////                Jtfsize.setText("Input size");
////            }
////        } else if (e.getSource() == Jtfcolor) {
////            if(Jtfcolor.getText() == ""){
////                Jtfcolor.setText("Input color");
////            }
////        } else if (e.getSource() == Jtfline) {
////            if(Jtfline.getText() == ""){
////                Jtfline.setText("Input line");
////            }
////        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
