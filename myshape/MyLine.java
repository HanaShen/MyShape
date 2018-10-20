/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myshape;

import java.awt.Stroke;
import java.awt.Paint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Graphics;

/**
 *
 * @author hanaa
 */
public class MyLine extends MyShape {
   
    public MyLine(){
       super();
    }
    
    public MyLine(Point sp, Point ep, Paint paint, Stroke stroke){
        super(sp,ep,paint, stroke);
    }
    @Override
     public void draw(Graphics2D g){
         g.setPaint( getPaint() );
         g.setStroke(getStroke());
         g.drawLine( getStartpX(),getStartpY(), getEndpX(), getEndpY());
     }
}
