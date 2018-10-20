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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Paint;
import java.awt.FlowLayout;
import java.awt. GridLayout;
import java.awt.GradientPaint;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JColorChooser;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Stroke;
import java.awt.BasicStroke;

public class DrawFrame extends JFrame{
     private DrawPanel Panel;
     private Color c1;
     private Color c2;   
     private float stroke_w;
     private final JButton button_undo;
     private final JButton button_clear;
     private final JButton color1;
     private final JButton color2;
     private final JComboBox box_shape;
     private final JCheckBox check_fill;
     private final JCheckBox check_gradient;
     private final JCheckBox dashed_solid;
     private final JLabel status_bar;
     private final JTextField stroke_width;
     private final JTextField stroke_dash_length;
     private float Dash[] = {1};
     private String Options_shape[] = {"Line", "Rectangle", "Oval"};
    public DrawFrame(){
        super("Java 2D Drawing");
        setLayout(new BorderLayout());
        //jlabel
        status_bar = new JLabel("");
        //jpanel
        Panel = new DrawPanel(status_bar);
        JPanel Component_Panel = new JPanel();
        JPanel Component_Panel2 = new JPanel();
        Component_Panel.setLayout(new FlowLayout());
        Component_Panel2.setLayout(new FlowLayout());
        JPanel panel_component = new JPanel(new GridLayout(2, 1));
        panel_component.add(Component_Panel);
        panel_component.add(Component_Panel2);
        add( Panel, BorderLayout.CENTER);
        add(panel_component, BorderLayout.NORTH);
        add(status_bar, BorderLayout.SOUTH);
        
        //jtextfield
        JLabel label_width = new JLabel("Line Width:");
        JLabel label_length = new JLabel("Dash Length:");
        stroke_width = new JTextField(1);
        stroke_dash_length = new JTextField (1);
        Component_Panel2.add(label_width);
        Component_Panel2.add(stroke_width);
        Component_Panel2.add(label_length);
        Component_Panel2.add(stroke_dash_length);
        TextFieldHandler handler = new TextFieldHandler();
        stroke_width.addActionListener(handler);
        stroke_dash_length.addActionListener(handler);
        //jbutton
        button_undo = new JButton("Undo");
        color1 = new JButton("1st Color");
        color2 = new JButton("2st Color");
        Component_Panel.add(button_undo);
        Component_Panel2.add(color1);
        Component_Panel2.add(color2);
        buttonHandler bhandler = new buttonHandler();
        button_undo.addActionListener(bhandler);
        color1.addActionListener(bhandler);
        color2.addActionListener(bhandler);
        
        button_clear = new JButton("Clear");
        Component_Panel.add(button_clear);
        button_clear.addActionListener(bhandler);
        
        //JCombo
        box_shape = new JComboBox(Options_shape);
        Component_Panel.add(box_shape);
        ComboBoxHandler boxhandler = new ComboBoxHandler();
        box_shape.addItemListener(boxhandler);
        //JCheckBox
        check_fill = new JCheckBox("Filled");
        check_gradient = new JCheckBox("Use a Gradient");
        dashed_solid = new JCheckBox("Dashed");
        Component_Panel.add(check_fill);
        Component_Panel2.add(check_gradient);
        Component_Panel2.add(dashed_solid);
        CheckBoxHandler checkboxhandler = new CheckBoxHandler();
        check_fill.addItemListener(checkboxhandler);
        check_gradient.addItemListener(checkboxhandler);
        dashed_solid.addItemListener(checkboxhandler);
        c1 = Color.BLACK;
        c2 = Color.BLACK;
        stroke_w = 1;
        Dash[0] = 2;
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize( 800, 500 );
        setVisible( true );
    }
     private class buttonHandler implements ActionListener{
          @Override
          public void actionPerformed(ActionEvent event){
               if (event.getActionCommand().equals("Undo")){
                   Panel.clearLastShape();
               }
               else if (event.getActionCommand().equals("Clear")){
                   Panel.clearDrawing();
               }
               else if (event.getActionCommand().equals("1st Color")){
                   JColorChooser chooser = new JColorChooser();
                   c1 = chooser.showDialog(null, "ColorChooser", c1);
                   Panel.setC1(c1);
               }
                   
               else {
                   JColorChooser chooser = new JColorChooser();
                   c2 = chooser.showDialog(null, "ColorChooser", c2);
                   Panel.setC2(c2);
         
                        
          }
     }
     }
     private class TextFieldHandler implements ActionListener{
          @Override
          public void actionPerformed(ActionEvent event){
               if (event.getSource()== stroke_width){
                  float set_width;
                  set_width = Float.parseFloat(stroke_width.getText());
                  stroke_w = set_width;
                  Stroke w = new BasicStroke(set_width);
                  Panel.setWidth(set_width);}
               
               else if (event.getSource() == stroke_dash_length){
                   float set_length;
                   set_length = Float.parseFloat(stroke_dash_length.getText());
                   Panel.setLength(set_length);
               }
               
           }       
            
    }
          
     private class CheckBoxHandler implements ItemListener{
          @Override
          public void itemStateChanged (ItemEvent event){
         {if (check_fill.isSelected()){
                 Panel.setFillShape(true);}
             else {
                 Panel.setFillShape(false);}}
         { if (check_gradient.isSelected()){
                 Panel.setGradient(true);
             }
             else {
                 Panel.setGradient(false);}}
         {if(dashed_solid.isSelected()){
                 Panel.setStroketf(true);
             }
             else{
                 Panel.setStroketf(false);
             }}
             }
         }   
    private class ComboBoxHandler implements ItemListener{
          @Override
          public void itemStateChanged (ItemEvent event){
           if(event.getStateChange() == ItemEvent.SELECTED)
               Panel.setType(box_shape.getSelectedIndex());   
         }
    }
}
    

    

     


