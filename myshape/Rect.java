/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myshape;

import java.awt.Paint;
import java.awt.Stroke;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.Graphics;

/**
 *
 * @author hanaa
 */
public class Rect extends TwoDShape {
    public Rect(){
        super();
    }
    public Rect(Point sp, Point ep, Paint paint, boolean fill, Stroke stroke){
        super(sp,ep, paint, fill, stroke);
    }
    @Override
    public void draw(Graphics2D g){
        g.setPaint(getPaint());
        g.setStroke(getStroke());
        if (getFill())
          g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        else
          g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
    }
}
