/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myshape;

/**
 *
 * @author hanaa
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.BasicStroke;
//import java.awt.geom.Point2D;
import java.awt.Point;
public abstract class MyShape {
    private Point sp;
    private Point ep;
    private Paint paint;
    private Stroke stroke;
    public MyShape(){
        sp = new Point(0,0);
        ep = new Point(0,0);
        paint = Color.BLACK;
        stroke = new BasicStroke();
    }
    public MyShape(Point sp, Point ep, Paint paint, Stroke stroke){
        this.sp = sp;
        this.ep = ep;
        this.paint = paint;
        this.stroke = stroke;
    }
  
    public void setStartPX(Point start){
        sp.x = start.x;
    }   
    public void setStatrY(Point start){
        sp.y = start.y;
    }   
    public void setEndPX(Point end){
        ep.x = end.x;
    }   
    public void setEndPY(Point end){
        ep.y = end.y;
    }   
    public void setColor(Paint paint){
        this.paint = paint;
    }
    public int getStartpX(){
         return sp.x;
     }
     public int getStartpY(){
         return sp.y;
     }
    public int getEndpX(){
        return ep.x;
    }
     public int getEndpY(){
         return ep.y;
     }
    public Paint getPaint(){
        return paint;
    }
    public Stroke getStroke(){
        return stroke;
    }
    public abstract void draw(Graphics2D g); 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DrawFrame newDraw = new DrawFrame();
        
		
    }
    
}

    /**
     * @param args the command line arguments
     */
   
    

