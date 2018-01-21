package ru.gui.mainframe.Trash;

import ru.model.rectangle.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class testFrame extends JFrame {

    private int hight = 1000;
    private int width = 1000;
    private double step;

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public testFrame(){
        super("Test");
        this.setSize(hight,width);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void DrawSomething(Rectangle rectangle){
        JPanel contentPane = new JPanel(){
            Graphics2D g2;

            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g2=(Graphics2D)g;
                g2.setColor(Color.BLACK);
                for(int i = 0; i < 3; i++){
                    Line2D line = new Line2D.Double(rectangle.getPoint(i).getX(),rectangle.getPoint(i).getY(),rectangle.getPoint(i+1).getX(),rectangle.getPoint(i+1).getY());
                g2.draw(line);
                }
                Line2D line = new Line2D.Double(rectangle.getPoint(0).getX(),rectangle.getPoint(0).getY(),rectangle.getPoint(3).getX(),rectangle.getPoint(3).getY());
                g2.draw(line);
            }
        };
        this.setContentPane(contentPane);
    }



}
