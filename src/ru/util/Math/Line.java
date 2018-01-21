package ru.util.Math;

public class Line {


    private Point a;
    private Point b;

    private double A;
    private double B;
    private double C;




    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
        Init();
    }

    private void Init(){
        double eps = (a.getX() == b.getX()) ? 0.0000001 : 0 ;
        double k = (b.getY()-a.getY())/(b.getX()-a.getX()+eps);
        double koef = b.getY()-k*b.getX();
        this.A = -k;
        this.B = 1;
        this.C = -koef;
    }


    public double getA() {
        return A;
    }

    public void setA(double a) {
        A = a;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    public double getC() {
        return C;
    }

    public void setC(double c) {
        C = c;
    }
}
