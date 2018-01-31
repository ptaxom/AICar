package ru.ai.teacher;

import ru.ai.net.Net;
import ru.model.Aims;
import ru.model.Obstacles;
import ru.model.Sensor;
import ru.model.car.Car;
import ru.model.rectangle.Rectangle;
import ru.util.Math.Operations;
import ru.util.Math.Point;
import ru.util.Math.Vector;

public class Teacher {

    public static double[] Teach(Car car, Obstacles obstacles, Aims aims){

        double[] answer = new double[1];
        double distance = Sensor.getSensetivy()*2;
        for(double angle = -Math.PI/4; angle < Math.PI/4; angle+=0.03){
           Point p1 = car.getRectangle().getCenter();


            Point p3 = aims.getCurPoint();
            Vector v = new Vector(p3.getX()-p1.getX(),p3.getY()-p1.getY());
            double dAngle = Math.abs((-Operations.Angle(v)+car.getRectangle().getAngle())*180/Math.PI);
            if (dAngle > 90)
                aims.Move();


           double angle2 = -car.getRectangle().getAngle()+angle;
           double R = car.getSpeed().getAbs();
           Point p2 = new Point(p1.getX()+R*Math.cos(angle2),p1.getY()+R*Math.sin(angle2));
           double ctrlDistance = Operations.distance(p1,aims.getCurPoint());
           double curDistance = Distance(p2,angle,obstacles,ctrlDistance,aims);
           if (curDistance < distance)
           {
               distance = curDistance;
               answer[0] = 0.5 - 2/Math.PI*angle;
           }
        }
        return answer;
    }


    private static double Distance(Point point, double angle, Obstacles obstacles, double ctrlDistance,Aims aims){
        double ans = 0;
        Rectangle rectangle = new Rectangle(point,0,0,angle);
        Car bufCar = new Car(rectangle,new Vector(),new Net());
        for(int i = 0; i < 5; i++)
            ans+=bufCar.getSensor(i).Data(bufCar, obstacles);
        if (Operations.distance(point,aims.getCurPoint()) >  ctrlDistance)
            ans = 1000;
//        System.out.println(ans);
        return ans;
    }


}
