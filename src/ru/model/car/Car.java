package ru.model.car;

import ru.model.Obstacles;
import ru.model.rectangle.Rectangle;
import ru.model.wall.Wall;
import ru.util.Math.Operations;
import ru.util.Math.Point;
import ru.util.Math.Vector;

public class Car {


    private static final double MaxSpeed = 3;
    private static final double MaxTurnSpeed = 1;
    private static final double crutch = 1;


    private boolean crashed = false;
    private Rectangle rectangle;
    private Vector speed;

    public Car(Rectangle rectangle, Vector speed) {
        this.rectangle = rectangle;
        this.speed = speed.Multiply((speed.getAbs() > MaxSpeed) ? MaxSpeed/speed.getAbs() : 1);
    }


    private void Update(){
        rectangle.setAngle(-Operations.Angle(speed));
        rectangle.Move(speed);
    }

    public void Think(Obstacles obstacles){
        Vector rotate = new Vector();
        double k = Math.random()*10000;
        int z = (k < 5000) ? 0 : 1;
        rotate = Operations.normal(speed,z);
        rotate.Multiply(0.03);
       // speed.Add(rotate);
        Update();
        if (obstacles.Distance(this) <= 1.5)
            crashed = true;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }


    public double getDistance(Wall wall){
        double distance = 10000;
        for(int i = 0; i < 4; i++)
            distance = (Operations.distance(rectangle.getPoint(i),wall.getLine()) < distance)
                    ? Operations.distance(rectangle.getPoint(i),wall.getLine())
                    : distance;
        return distance;
    }

    public boolean isCrashed() {
        return crashed;
    }



}
