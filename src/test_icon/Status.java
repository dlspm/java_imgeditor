/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_icon;

/**
 *
 * @author angus
 */
public enum Status {
    Drawing,Selection,
    CreatingOBJ, EllipseOBJ, PeningOBJ, RectingOBJ, ImgingOBJ, TextingOBJ, DowingOBJ, IconingOBJ,
    Activated, Inactivated, MovingOBJ, Moving,
    Ready2Resize, Resizing ,ObjectLine,
    
    //為了讓 ToolBar 有相對應的 ParametersBar
    ToolBarPan, ToolBarNewPage, ToolBarRect, ToolBarImg, ToolBarText, ToolBarDow, ToolBarIcon, ToolBarSele, ToolBarDele, ToolBarOval
    
}
