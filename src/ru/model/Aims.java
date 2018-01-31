package ru.model;

import ru.util.Math.Point;

import java.util.ArrayList;
import java.util.List;

public class Aims {

    private List<Point> points;
    private int cur = 0;

    public Aims() {
        points = new ArrayList<>();
    }


    public Point getPoints(int num) {
        return points.get(num);
    }

    public Point getCurPoint(){
        if (cur >= points.size())
            cur = 0;
        return this.points.get(cur);
    }

    public void Add(Point point){
        points.add(point);
    }

    public void Move(){
        cur++;
    }


}
