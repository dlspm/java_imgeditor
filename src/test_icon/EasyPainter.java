/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

import java.util.Vector;


import test_icon.MainWindow;
import test_icon.MessageBar;
import test_icon.ImgPage;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;

/**
 *
 * @author angus
 */
class EasyPainter {
    
    public String swTitle = "JP";
    public String version = "4.0";
    public MessageBar megBar;
    public ToolBar toolBar;
//    public ImgPage imgPage = null;
    public ParametersBar parametersBar;
    
    public MainWindow mainWin;
    public int curPages = 0;
    public int numPages = 0;
    
    public ImgPage activePage = null;

    public Vector<ImgPage> pages = null;
    String Title;

    EasyPainter() throws MalformedURLException {

        mainWin = new MainWindow(this);
        megBar = new MessageBar(this);
        toolBar = new ToolBar(this);
        activePage = new ImgPage(this);
        parametersBar = new ParametersBar(this);
        
        pages = new Vector<ImgPage>();
        mainWin.setMessageBar(megBar);
        mainWin.setToolBar(toolBar);
//        mainWin.setImgPage(ImgPage);
        mainWin.setParametersBar(parametersBar);
        
        mainWin.setVisible(true);
    }
}
