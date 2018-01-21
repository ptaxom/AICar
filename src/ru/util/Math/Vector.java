package ru.util.Math;

public class Vector {

    private double x;
    private double y;


    public Vector() {
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void Add(Vector b){
        x+=b.getX();
        y+=b.getY();
    }

    public Vector Multiply(double k){
        x*=k;
        y*=k;
        return this;
    }

    public double getAbs(){
        return Math.sqrt(x*x+y*y);
    }

}
