package ru.Initialization;

import ru.model.Obstacles;
import ru.model.wall.Wall;
import ru.util.Math.Point;

import java.io.*;

public class ObstaclesReader {

    public static Obstacles Read(){
        Obstacles obstacles = new Obstacles();
        String path = "res//Walls.txt";
        File file = new File(path);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String s;
            while ( (s = reader.readLine()) != null){
                String[] values = s.split(" ");
                double[] point = new double[4];
                for(int i = 0; i<4;i++)
                point[i] = Double.parseDouble(values[i]);
                obstacles.Add(new Wall(new Point(point[0],point[1]), new Point(point[2],point[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obstacles;
    }

}
