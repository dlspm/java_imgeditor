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
    JButton Btnbig, Btnsmall, Btnall, Btnchoose;
    public Status status;
    
    ParametersBar(EasyPainter ep){
        this.setLayout(new GridLayout(7, 1));

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
        
        Btnbig = new JButton("變大");
        Btnbig.setVisible(false);
        Btnsmall = new JButton("變小");
        Btnsmall.setVisible(false);
        Btnall = new JButton("全部");
        Btnall.setVisible(false);
        Btnchoose = new JButton("選取");
        Btnchoose.setVisible(false);
        
        

        this.add(Jtfsize);
        this.add(Jtfcolor);
        this.add(Jtfline);
        this.add(Btnbig);
        Btnbig.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("變大");
            }
        
        });
        
        this.add(Btnbig);
        Btnsmall.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("變小");
            }
        
        });
        
        this.add(Btnsmall);
        
        
        Btnall.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("全部");
            }
        
        });
        
        this.add(Btnall);
        Btnchoose.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("選取");
            }
        
        });
        this.add(Btnchoose);

        this.setSize(100, 600);
    
    }
    //ToolBarPan, ToolBarNewPage, ToolBarRect, ToolBarImg
    public void setToolBarPan(){//Btnbig, Btnsmall, Btnall, Btnchoose;
        Btnbig.setVisible(false);
        Btnsmall.setVisible(false);
        Btnall.setVisible(false);
        Btnchoose.setVisible(false);
        Jtfline.setVisible(true);
        Jtfcolor.setVisible(true);
        Jtfsize.setVisible(true);
        
        this.revalidate();
    }
    
    public void setToolBarNewPage(){
        Btnbig.setVisible(false);
        Btnsmall.setVisible(false);
        Btnall.setVisible(false);
        Btnchoose.setVisible(false);
        Jtfline.setVisible(false);
        Jtfcolor.setVisible(false);
        Jtfsize.setVisible(false);
        
        this.revalidate();
    }
    
    public void setToolBarRect(){
        Btnbig.setVisible(false);
        Btnsmall.setVisible(false);
        Btnall.setVisible(false);
        Btnchoose.setVisible(false);
        Jtfline.setVisible(true);
        Jtfcolor.setVisible(true);
        Jtfsize.setVisible(true);
        
        this.revalidate();
    }
    
    public void setToolBarImg(){
        Btnbig.setVisible(true);
        Btnsmall.setVisible(true);
        Btnall.setVisible(false);
        Btnchoose.setVisible(false);
        Jtfline.setVisible(false);
        Jtfcolor.setVisible(false);
        Jtfsize.setVisible(false);
        
        this.revalidate();
    }
    
    public void setToolBarText(){
        Btnbig.setVisible(false);
        Btnsmall.setVisible(false);
        Btnall.setVisible(false);
        Btnchoose.setVisible(false);
        Jtfline.setVisible(false);
        Jtfcolor.setVisible(true);
        Jtfsize.setVisible(true);
        
        this.revalidate();
    }
    
    public void setToolBarDow(){
        Btnbig.setVisible(false);
        Btnsmall.setVisible(false);
        Btnall.setVisible(true);
        Btnchoose.setVisible(true);
        Jtfline.setVisible(false);
        Jtfcolor.setVisible(false);
        Jtfsize.setVisible(false);
        
        this.revalidate();
    }
    
    public void setToolBarIcon(){
        Btnbig.setVisible(false);
        Btnsmall.setVisible(false);
        Btnall.setVisible(false);
        Btnchoose.setVisible(false);
        Jtfline.setVisible(false);
        Jtfcolor.setVisible(false);
        Jtfsize.setVisible(true);
        
        this.revalidate();
    }
    
    public void setToolBarSele(){
        Btnbig.setVisible(false);
        Btnsmall.setVisible(false);
        Btnall.setVisible(false);
        Btnchoose.setVisible(false);
        Jtfline.setVisible(false);
        Jtfcolor.setVisible(false);
        Jtfsize.setVisible(false);
        
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
