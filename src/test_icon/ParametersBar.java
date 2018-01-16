/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author angus
 */
//public class ParametersBar extends JPanel implements FocusListener{
  public class ParametersBar extends JPanel{  
    JTextField Jtfsize, Jtfcolor, Jtfline;
    JButton Btnsele;
    public Status status;
    
    ParametersBar(EasyPainter ep){
        this.setLayout(new GridLayout(4, 1));

        status = Status.ToolBarNewPage; //因為一定是從 NewPage 開始
        
        
        Jtfsize = new JTextField(7);
        Jtfsize.setText("輸入大小");
        Jtfsize.setVisible(false);
        Jtfcolor = new JTextField(7);
        Jtfcolor.setText("輸入顏色");
        Jtfcolor.setVisible(false);
        Jtfline = new JTextField(7);
        Jtfline.setText("輸入粗細");
        Jtfline.setVisible(false);
        
//        Jtfsize.addFocusListener(this);
//        Jtfcolor.addFocusListener(this);
//        Jtfline.addFocusListener(this);
        
        Btnsele = new JButton("選取物件");
        Btnsele.setVisible(false);

        this.add(Jtfsize);
        this.add(Jtfcolor);
        this.add(Jtfline);
        this.add(Btnsele);
        Btnsele.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("選取物件");
            }
        
        });
        

        this.setSize(100, 600);
    
    }
    //ToolBarPan, ToolBarNewPage, ToolBarRect, ToolBarImg
    public void setToolBarPan(){
        Btnsele.setVisible(true);
        Jtfline.setVisible(true);
        Jtfcolor.setVisible(true);
        Jtfsize.setVisible(true);
        
        this.revalidate();
    }
    
    public void setToolBarNewPage(){
        Btnsele.setVisible(true);
        Jtfline.setVisible(false);
        Jtfcolor.setVisible(false);
        Jtfsize.setVisible(false);
        
        this.revalidate();
    }
    
    public void setToolBarRect(){
        Btnsele.setVisible(true);
        Jtfline.setVisible(true);
        Jtfcolor.setVisible(true);
        Jtfsize.setVisible(true);
        
        this.revalidate();
    }
    
    public void setToolBarImg(){
        Btnsele.setVisible(true);
        Jtfline.setVisible(false);
        Jtfcolor.setVisible(false);
        Jtfsize.setVisible(true);
        
        this.revalidate();
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
