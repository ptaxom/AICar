package ru.model.rectangle;

import ru.util.Math.Operations;
import ru.util.Math.Point;
import ru.util.Math.Vector;

public class Rectangle {

    private Point center;
    private Point[] points = new Point[4];
    private double width;
    private double length;
    private double angle;


    public Rectangle(Point center, double width, double length, double angle) {
        this.center = center;
        this.width = width;
        this.length = length;
        this.angle = angle;
        Init();
    }

    private void Init(){
        Rotation();
    }

    private void Rotation(){
      Point[] buf = new Point[4];
        buf[0] = new Point(length/2,width/2);
        buf[1] = new Point(length/2,-width/2);
        buf[2] = new Point(-length/2,-width/2);
        buf[3] = new Point(-length/2,width/2);
      for(int i = 0; i < 4; i++) {
          buf[i] = Operations.Rotate(buf[i],angle);
          points[i] = new Point(center.getX() + buf[i].getX(), center.getY() + buf[i].getY());
      }
    }

    public void Rotate(double angle){
        this.angle+=angle;
        Rotation();
    }

    public void setAngle(double angle) {
        this.angle = angle;
        Rotation();
    }

    public void Move(Vector vector){
        center.setX(center.getX()+vector.getX());
        center.setY(center.getY()+vector.getY());
        Rotation();
    }


    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getAngle() {
        return angle;
    }

    public Point getPoint(int num){
        return points[num];
    }
}

