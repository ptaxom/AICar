package ru.util.Math;

public class Operations {


    public static double sqr(double x){
        return x*x;
    }
    public static double distance(Point a, Point b){
        return Math.sqrt(sqr(a.getX()-b.getX())+ sqr(a.getY()-b.getY()));
    }

    public static double distance(Point a, Line b){
        return Math.abs(a.getX()*b.getA()+a.getY()*b.getB()+b.getC())/Math.sqrt(sqr(b.getA()) + sqr(b.getB()));
    }

    public static Point crossing(Line a, Line b){
        double detC = (a.getA()*b.getB()) - (b.getA()*a.getB());
        double detX = (-a.getC()*b.getB()) - (-b.getC()*a.getB());
        double detY = (a.getA()*-b.getC()) - (b.getA()*-a.getC());
        return new Point(detX/detC,detY/detC);
    }

    public static Vector normal(Vector a, int type){
        double angle = (type == 0) ? -Math.PI/2 : +Math.PI/2;
        double x = a.getX()*Math.cos(angle) - a.getY()*Math.sin(angle);
        double y = a.getX()*Math.sin(angle) + a.getY()*Math.cos(angle);
        double abs = Math.sqrt(x*x+y*y);
        return new Vector(x/abs, y/abs);
    }

    public static Point Rotate(Point a, double angle){
        double x = +a.getX()*Math.cos(angle) + a.getY()*Math.sin(angle);
        double y = -a.getX()*Math.sin(angle) + a.getY()*Math.cos(angle);
        return new Point(x,y);
    }

    public static double Angle(Vector vector){
        return Math.atan2(vector.getY(),vector.getX());
    }


    public static Vector Rotate(Vector a, double angle){
        double x = a.getX()*Math.cos(angle) - a.getY()*Math.sin(-angle);
        double y = a.getX()*Math.sin(-angle) + a.getY()*Math.cos(angle);
        return new Vector(x, y);
    }


}
