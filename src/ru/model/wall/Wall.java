package ru.model.wall;

import ru.model.car.Car;
import ru.model.rectangle.Rectangle;
import ru.util.Math.Line;
import ru.util.Math.Point;

public class Wall {

    private Point p1;
    private Point p2;
    private Line line;


    public Wall(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.line = new Line(p1,p2);
    }


    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Line getLine() {
        return line;
    }
}
