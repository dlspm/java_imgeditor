/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;


import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author angus
 */
public class MainWindow extends JFrame{  //用extends 去繼承 Frame
    //呈現視窗裡面的一些內容(功能表)
//    JPanel thePanel;
//    Container thePanel;
    Container cpanel = this.getContentPane();
    MainWindow(EasyPainter ep)
    {
        
        
        this.pack(); // 用來將視窗中的各個元件，自動依版面配置作適當的排列。
        this.setLocation(100, 20);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE); //關閉事件

    }
    
    void setToolBar(ToolBar tb){
        cpanel.add(tb, BorderLayout.WEST);
    }
    void setMessageBar(MessageBar mb){
        cpanel.add(mb, BorderLayout.SOUTH);
    }
    void setImgPage(ImgPage ip){
        cpanel.add(ip, BorderLayout.CENTER);
    }
    void setParametersBar(ParametersBar p){
        cpanel.add(p, BorderLayout.EAST);
    }
    
}