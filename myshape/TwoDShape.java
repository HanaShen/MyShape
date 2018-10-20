/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myshape;

import java.awt.Paint;
import java.awt.Stroke;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author hanaa
 */
public abstract class TwoDShape extends MyShape {
    private boolean fill;

   public TwoDShape(){ 
       super();
       fill = false;
    }
    public TwoDShape(Point sp, Point ep, Paint paint, boolean fill, Stroke stroke){
       super(sp, ep, paint, stroke);
        this.fill = fill;
    }
    public void setFill(boolean fill){
        this.fill = fill;
    }
    public boolean getFill(){
        return fill;
    }
    public int getUpperLeftX(){
        return Math.min(getStartpX(), getEndpX());   
    }
     public int getUpperLeftY(){
        return Math.min(getStartpY(), getEndpY());  
    }
    public int getWidth(){
        return Math.abs(getEndpX() - getStartpX());
    }
     public int getHeight(){
         return Math.abs(getEndpY() - getStartpY());
     }
     
    @Override
     public abstract void draw(Graphics2D g);
}



