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
import java.awt.GradientPaint;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Paint;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import  java.awt.MouseInfo;
import java.util.ArrayList;
import  java.awt.Point;
public class DrawPanel extends JPanel {
    private ArrayList<MyShape> shapes;
    private int shapeType;
    private MyShape currentShape;
    private Paint currentPaint;
    private boolean filledShape;
    private Color c1;
    private Color c2;
    private float width;
    private boolean gradient;
    private Stroke currentStroke;
    private boolean stroke;
    private float length;
    JLabel status_bar ; //represent the status bar (display the coordinates of the current mouse position
    public DrawPanel(JLabel status_bar){
        this.status_bar = status_bar;
        shapes = new ArrayList<MyShape>();
        shapeType=0;
        currentShape =null;
        currentPaint= Color.BLACK;
        gradient = false;
        stroke = false;
        filledShape=false;
        length = 1;
        currentStroke = new BasicStroke(); 
        setLayout(new BorderLayout()); 
        setBackground( Color.WHITE );
        add(status_bar, BorderLayout.SOUTH);
        addMouseMotionListener(new MouseEvents());
        addMouseListener(new MouseEvents());
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (MyShape currentshape : shapes){
            //System.out.println("shape " + currentshape);
            if(currentshape!= null)
               currentshape.draw(g2d);
        }
    }

    public void setType(int shapeType){
        this.shapeType = shapeType;
    }
    public void setC1 (Color c1){
        this.c1 = c1;
    }
    public void setC2 (Color c2){
        this.c2 = c2;
    }
    public void setPaint (Paint currentPaint){
        this.currentPaint = currentPaint;
    }
    public void setGradient(boolean gradient){
        this.gradient = gradient;
    }
    public void setStroketf(boolean stroke){
        this.stroke = stroke;
    }
    public void setWidth(float width){
        this.width = width;
    }
    public void setLength(float length){
        this.length = length;
    }
    public void setStroke(Stroke currentStroke){
        this.currentStroke = currentStroke;
    }
    public void setFillShape(boolean filledShape){
        this.filledShape = filledShape;
    }
    public void clearLastShape(){
        shapes.remove(shapes.size()-1);
        super.repaint();
    }
    public void clearDrawing(){
        shapes.clear();
        super.repaint();
    }
    private class MouseEvents extends MouseAdapter implements MouseMotionListener{ //handle all mouse events in one class
        @Override 
        public void mousePressed(MouseEvent event){
             if (gradient){
               Paint p = new GradientPaint(0,0,c1,50,50,c2,true);
               setPaint(p);
             }
             else{
                 setPaint(c1);
             }
             if (stroke){
                 float dash1[] = {length};
                 Stroke s = new BasicStroke(width, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10, dash1, 0);
                 setStroke(s);
             }
             else{
                 Stroke s1 = new BasicStroke(width);
                 setStroke(s1);
             }
             if (shapeType == 0){
                currentShape = new MyLine(event.getPoint(),event.getPoint(), currentPaint, currentStroke);
                shapes.add(currentShape);
                repaint();}
             else if (shapeType == 1){
              currentShape = new Rect (event.getPoint(),event.getPoint(), currentPaint, filledShape, currentStroke);
              shapes.add(currentShape);
              repaint();}
             else {
             currentShape = new Oval (event.getPoint(),event.getPoint(), currentPaint, filledShape,currentStroke);
             shapes.add(currentShape);
             repaint();}
            
        }      
        
        @Override
        public void mouseReleased(MouseEvent event){
            currentShape.setEndPX(event.getPoint());
            currentShape.setEndPY(event.getPoint());
            repaint();
        }
        @Override
        public void mouseMoved(MouseEvent event){
             status_bar.setText(String.format("Mouse Coordinates X: %d Y: %d",event.getX(),event.getY()));
            }
        @Override
        public void mouseDragged(MouseEvent event){
            currentShape.setEndPX(event.getPoint());
            currentShape.setEndPY(event.getPoint());
            repaint();
        }
    }

}

