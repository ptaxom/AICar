package ru.model;

import ru.model.car.Car;
import ru.model.wall.Wall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Obstacles {

    private List<Wall> walls = new LinkedList<>();

    public void Add(Wall wall){
        walls.add(wall);
    }

    public Wall getWall(int num) {
        return walls.get(num);
    }

    public int getSize(){
        return walls.size();
    }

    public double Distance(Car car){
        double distance = 10000;
        for(Wall wall : walls)
            if (car.getDistance(wall) < distance)
                distance = car.getDistance(wall);
        return distance;
    }
}
