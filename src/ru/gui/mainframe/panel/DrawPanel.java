package ru.gui.mainframe.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import ru.model.Aims;
import ru.model.Obstacles;
import ru.model.car.Car;
import ru.model.rectangle.Rectangle;
import ru.util.Math.Vector;

public class DrawPanel extends JPanel implements Runnable{

    private Car car;
    private Obstacles obstacles;
    private Aims aims;


    public DrawPanel(Car car,Obstacles obstacles,Aims aims) {
        this.car = car;
        this.obstacles = obstacles;
        this.aims = aims;
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
//        for(int i = 0; i < 5; i++){
//            Line2D line2D = new Line2D.Double(car.getSensor(i).getP1().getX(),car.getSensor(i).getP1().getY(),
//                                                car.getSensor(i).getP2().getX(),car.getSensor(i).getP2().getY());
//            g2.draw(line2D);
//        }
        Color color = g2.getColor();
        g2.setColor(new Color(255,0,0));
        double x = aims.getCurPoint().getX();
        double y = aims.getCurPoint().getY();
        double R = 7;
        g2.draw(new Ellipse2D.Double(x-R/2,y-R/2,R,R));
        g2.setColor(color);

    }


    @Override
    public void run() {
        while (!car.isCrashed()){
            try {
                super.repaint();
                car.Think(obstacles,aims);
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (car.isCrashed())
                Thread.currentThread().interrupt();
        }
    }
}
