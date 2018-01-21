package ru.gui.mainframe.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

import ru.model.Obstacles;
import ru.model.car.Car;
import ru.model.rectangle.Rectangle;
import ru.util.Math.Vector;

public class DrawPanel extends JPanel implements Runnable{

    private Car car;
    private Obstacles obstacles;


    public DrawPanel(Car car,Obstacles obstacles) {
        this.car = car;
        this.obstacles = obstacles;
        (new Thread(this)).start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        Rectangle rectangle = car.getRectangle();
        for(int i = 0; i < 3; i++){
            Line2D line = new Line2D.Double(rectangle.getPoint(i).getX(),rectangle.getPoint(i).getY(),rectangle.getPoint(i+1).getX(),rectangle.getPoint(i+1).getY());
            g2.draw(line);
        }
        Line2D line2 = new Line2D.Double(rectangle.getPoint(0).getX(),rectangle.getPoint(0).getY(),rectangle.getPoint(3).getX(),rectangle.getPoint(3).getY());
        g2.draw(line2);
        for(int i = 0; i < obstacles.getSize(); i++)
        {
            Line2D line = new Line2D.Double(obstacles.getWall(i).getP1().getX(),obstacles.getWall(i).getP1().getY(),
                            obstacles.getWall(i).getP2().getX(),obstacles.getWall(i).getP2().getY());
            g2.draw(line);
        }
    }


    @Override
    public void run() {
        while (!car.isCrashed()){
            try {
                super.repaint();
                car.Think(obstacles);
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
