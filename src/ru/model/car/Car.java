package ru.model.car;

import ru.ai.net.Net;
import ru.ai.teacher.Teacher;
import ru.model.Aims;
import ru.model.Obstacles;
import ru.model.Sensor;
import ru.model.rectangle.Rectangle;
import ru.model.wall.Wall;
import ru.util.Math.Operations;
import ru.util.Math.Point;
import ru.util.Math.Vector;

public class Car {


    private static final double MaxSpeed = 3;
    private static final double MaxTurnSpeed = 1;
    private static final double crutch = 1;
    private static final double SensorsStep = Math.PI*35/180;


    private boolean crashed = false;
    private Rectangle rectangle;
    private Vector speed;
    private Sensor[] sensor;
    private Net net;

    public Car(Rectangle rectangle, Vector speed, Net net) {
        this.net = net;
        this.rectangle = rectangle;
        this.speed = speed.Multiply((speed.getAbs() > MaxSpeed) ? MaxSpeed/speed.getAbs() : 1);
        sensor = new Sensor[5];
        for(int i = -2; i < 3; i++)
            sensor[i+2] = new Sensor(i*SensorsStep);
    }


    public void Update(){
        rectangle.setAngle(-Operations.Angle(speed));
        rectangle.Move(speed);
        for(int i = 0; i < 5; i++)
            sensor[i].Update(this);
    }

    public void Think(Obstacles obstacles, Aims aims){
        double[] data = new double[5];
        for(int i = 0; i < 5; i++)
            data[i] = this.getSensor(i).Data(this,obstacles)/Sensor.getSensetivy();
        double[] move = new double[1];
        move = net.Activate(data);
        Vector vector = new Vector();
        vector = Operations.Rotate(speed,Math.PI*(move[0]-0.5)/2);
        net.Teach(Teacher.Teach(this,obstacles,aims));
        speed = vector;
        Update();
        if (obstacles.Distance(this) <= 1.5)
            crashed = true;
    }

    public void Turn(int type){
        Vector rotate = new Vector();
        rotate = Operations.normal(speed,type);
        rotate.Multiply(0.08);
        speed.Add(rotate);
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

    public Vector getSpeed() {
        return speed;
    }

    public boolean isCrashed() {
        return crashed;
    }


    public Sensor getSensor(int num){
        return sensor[num];
    }


}
