/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;
import test_icon.ImgPage;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;



/**
 *
 * @author angus
 */
//public class ParametersBar extends JPanel implements FocusListener{
  public class ParametersBar extends JPanel{  
    JTextField Jtfsize, Jtfcolor, Jtfline, Jftimgpath;
    JButton Btnbig, Btnsmall, Btnall, Btnchoose;
    JComboBox Jcboutput ;
    public Status status;
    public EasyPainter ep;
    
    String filename="";
    
    JButton jb1, jb2;
    JTextField jtf1, jtf2, jtf3;
//    ImgPage ip = new ImgPage();
    
    ParametersBar(EasyPainter ep){
        this.setLayout(new GridLayout(9, 1));
        ep=ep;
        status = Status.ToolBarNewPage; //因為一定是從 NewPage 開始
        
        Jtfsize = new JTextField(15);
        Jtfcolor = new JTextField(15);
        Jtfline = new JTextField(15);
        Jftimgpath = new JTextField(15);
        
        String info1 = "輸入大小";
        String info2 = "輸入顏色";
        String info3 = "輸入粗細";
        String info4 = "輸入圖片名稱";
        
        Jtfsize.setText(info1);
        Jtfcolor.setText(info2);
        Jtfline.setText(info3);
        Jftimgpath.setText(info4);
        
        this.add(Jtfsize);
        this.add(Jtfcolor);
        this.add(Jtfline);
        this.add(Jftimgpath);
        
        Jtfsize.addFocusListener(new MyFocusListener(info1, Jtfsize));//添加焦点事件反映  
        Jtfcolor.addFocusListener(new MyFocusListener(info2, Jtfcolor));
        Jtfline.addFocusListener(new MyFocusListener(info3, Jtfline));
        Jftimgpath.addFocusListener(new MyFocusListener(info4, Jftimgpath));
        
        Jtfsize.addKeyListener(new MyKeyListener(Jtfsize));
        Jtfcolor.addKeyListener(new MyKeyListener(Jtfcolor));
        Jtfline.addKeyListener(new MyKeyListener(Jtfline));
        Jftimgpath.addKeyListener(new MyKeyListener(Jftimgpath));
        
        Jtfsize.setVisible(false);
        Jtfcolor.setVisible(false);
        Jtfline.setVisible(false);
        Jftimgpath.setVisible(false);
        
//        String[] option = new String[]{"選項一", "選項二"};
//        Jcboutput = new JComboBox(option);
//
//        Jcboutput.setVisible(false);
//        this.add(Jcboutput);
        
        Btnbig = new JButton("變大");
        Btnbig.setVisible(false);
        Btnsmall = new JButton("變小");
        Btnsmall.setVisible(false);
        Btnall = new JButton("全部");
        Btnall.setVisible(false);
        Btnchoose = new JButton("選取");
        Btnchoose.setVisible(false);
        
        
        
        this.add(Btnbig);
        Btnbig.addMouseListener(new MyMouseListener());
//        Btnbig.addMouseListener(new MouseAdapter()
//        {
//            public void mouseClicked(MouseEvent e)
//            {
//                System.out.println("變大");
//            }
//        
//        });
        
        this.add(Btnsmall);
        Btnsmall.addMouseListener(new MyMouseListener());
//        Btnsmall.addMouseMotionListener(l);
//        Btnsmall.addMouseListener(new MouseAdapter()
//        {
//            public void mouseClicked(MouseEvent e)
//            {
//                System.out.println("變小");
//            }
//        
//        });
        
        this.add(Btnall);
        Btnall.addMouseListener(new MyMouseListener());
//        Btnall.addMouseListener(new MouseAdapter()
//        {
//            public void mouseClicked(MouseEvent e)
//            {
//                System.out.println("全部");
//            }
//        
//        });
        
        this.add(Btnchoose);
        Btnchoose.addMouseListener(new MyMouseListener());
//        Btnchoose.addMouseListener(new MouseAdapter()
//        {
//            public void mouseClicked(MouseEvent e)
//            {
//                System.out.println("選取");
//            }
//        
//        });
        
        

        //test：
//        jtf1 = new JTextField(10);
//        jtf2 = new JTextField(10);
//        jtf3 = new JTextField(10);
//        String info1 = "请输入 [账号]";
//        String info2 = "请输入 <密码>";
//        String info3 = "fuck";
//        jtf1.setText(info1);
//        jtf2.setText(info2);
//        jtf3.setText(info3);
//        this.add(jtf1);
//        this.add(jtf2);
//        this.add(jtf3);
//        jtf1.addFocusListener(new MyFocusListener(info1, jtf1));//添加焦点事件反映  
//        jtf2.addFocusListener(new MyFocusListener(info2, jtf2));
//        jtf3.addFocusListener(new MyFocusListener(info3, jtf3));
//        jtf1.addKeyListener(new MyKeyListener(jtf1));
//        jtf2.addKeyListener(new MyKeyListener(jtf2));
//        jtf3.addKeyListener(new MyKeyListener(jtf3));



        this.setSize(100, 600);
    
    }
    //ToolBarPan, ToolBarNewPage, ToolBarRect, ToolBarImg
    public void setToolBarPan(){//Btnbig, Btnsmall, Btnall, Btnchoose;
        Jftimgpath.setVisible(false);
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
        Jftimgpath.setVisible(false);
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
        Jftimgpath.setVisible(false);
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
        Jftimgpath.setVisible(true);
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
        Jftimgpath.setVisible(false);
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
        Jftimgpath.setVisible(true);
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
        Jftimgpath.setVisible(false);
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
        Jftimgpath.setVisible(false);
        Btnbig.setVisible(false);
        Btnsmall.setVisible(false);
        Btnall.setVisible(false);
        Btnchoose.setVisible(false);
        Jtfline.setVisible(false);
        Jtfcolor.setVisible(false);
        Jtfsize.setVisible(false);
        
        this.revalidate();
    }

    
    class MyMouseMotionListener implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    
    }
    
//    JButton Btnbig, Btnsmall, Btnall, Btnchoose;
    
    class MyMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == Btnbig){
                Point x ;
                System.out.println("變大");
//                x = p.activePage.activeOBJ.getLocation();
//                p.activePage.activeOBJ.setLocation((x.x)+20, (x.y)+20);
//                p.activePage.addOBJ(no);
                
            }else if(e.getSource() == Btnsmall){
                System.out.println("變小");
            }else if(e.getSource() == Btnall){
                System.out.println("全部");
                ep.activePage.Dowimg(filename);                
            }else if(e.getSource() == Btnchoose){
                System.out.println("選取");
                try {
                    ep.activePage.Seledowimg("img/" + filename);
                    //需要先劃出一個框
                } catch (Exception ex) {
                    Logger.getLogger(ParametersBar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    
    
    }
    //Jtfsize, Jtfcolor, Jtfline, Jftimgpath;
    class MyKeyListener  implements KeyListener{
        JTextField jtf;
        public MyKeyListener(JTextField jtf){
            this.jtf = jtf;
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            String temp = jtf.getText();
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                System.out.println("！！！！！！！！"+temp);
//                jtf.setText(""); //會有 Error
                
                //要去啟動 更改 ImgPage ToolBar 
                if(e.getSource() == Jtfsize){
                    
                }else if(e.getSource() == Jtfcolor){
                    
                }else if(e.getSource() == Jtfline){
                    
                }else if(e.getSource() == Jftimgpath){
                    
                    
                    if (status == Status.ToolBarImg){
                        System.out.println("！！！！！！！！" + "Jftimgpath" + temp);
                        //
                        Img no = null;
                        try {
                            no = new Img(temp, ep);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(ParametersBar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ep.activePage.addOBJ(no);
                        ep.activePage.activeOBJ = no;
                    }else if(status == Status.ToolBarDow){
                        filename = temp;
//                        p.activePage.Dowimg(temp);
                    }

                }
                
            }
        }
    }


    class MyFocusListener implements FocusListener {

        String info;
        JTextField jtf;

        public MyFocusListener(String info, JTextField jtf) {
            this.info = info;
            this.jtf = jtf;
        }

        @Override
        public void focusGained(FocusEvent e) {//获得焦点的时候,清空提示文字  
            String temp = jtf.getText();
            
            if (temp.equals(info)) {
                jtf.setText("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {//失去焦点的时候,判断如果为空,就显示提示文字  
            String temp = jtf.getText();
            
            if (temp.equals("")) {
                jtf.setText(info);
            }
        }
    }
    
}
