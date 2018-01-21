package ru.util.Math;

public class Point {


    private double x;
    private double y;
    private static double eps = 0;

    public Point(double x, double y) {
        this.x = x + eps;
        this.y = y + eps;
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

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
