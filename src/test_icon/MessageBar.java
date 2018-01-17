/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MessageBar extends JPanel {
    JLabel pageInfo;
    JButton Btnup, Btndon;
            
    MessageBar(EasyPainter ep)
    {
        this.setLayout(new FlowLayout());
        this.setBackground(Color.lightGray);
        pageInfo = new JLabel();
        Btnup = new JButton("上");
        Btndon = new JButton("下");
        this.updateInfo(ep.curPages, ep.numPages);
//        pageInfo=new Label("[" + ep.curPage + "/" + ep.numPages + "]");
        this.add(pageInfo);
        this.add(Btnup);
        this.add(Btndon);
    }
    
    void updateInfo(int cp, int np)
    {
        pageInfo.setText("[" + cp + "/" + np + "]");
    }
}
