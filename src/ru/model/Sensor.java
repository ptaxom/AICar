package ru.model;

import ru.model.car.Car;
import ru.util.Math.Line;
import ru.util.Math.Operations;
import ru.util.Math.Point;

public class Sensor {


    private static final double sensetivy = 100;

    private double angle;
    private Point p1;
    private Point p2;

    public Sensor(double angle) {
        this.angle = angle;
    }

    public void Update(Car car){
        p1 = car.getRectangle().getCenter();
        double angle2 = -car.getRectangle().getAngle()+angle;
        p2 = new Point(p1.getX()+sensetivy*Math.cos(angle2),p1.getY()+sensetivy*Math.sin(angle2));
    }

    public double Data(Car car, Obstacles obstacles){
        double ans =0;
        Update(car);
        Line line = new Line(p1,p2);
        double k = 10000;
        for(int i = 0; i < obstacles.getSize(); i++){
            Point p3 = Operations.crossing(line,obstacles.getWall(i).getLine());
            if (line.Belongs(p3) && Operations.distance(p1,p3) < k)
                k = Operations.distance(p1,p3);
        }
        if (k<=sensetivy)
            ans = k;
        return ans;
    }

    public static double getSensetivy() {
        return sensetivy;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }
}
