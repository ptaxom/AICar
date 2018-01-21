package ru.gui.mainframe.panel;

import ru.model.Obstacles;
import ru.model.car.Car;
import ru.model.rectangle.Rectangle;
import ru.model.wall.Wall;
import ru.util.Math.Operations;
import ru.util.Math.Point;
import ru.util.Math.Vector;

import javax.swing.*;
import java.awt.*;

public class Test {


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Animation");
        frame.setSize(1000,1000);
        frame.setLayout(new GridLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Rectangle rectangle = new Rectangle(new Point(400,400),20,40,0);
        Car car = new Car(rectangle, new Vector(2,0));
        Obstacles obstacles = new Obstacles();
        obstacles.Add(new Wall(new Point(400,388), new Point(800,388)));
        obstacles.Add(new Wall(new Point(800,388), new Point(800,412)));
        DrawPanel panel = new DrawPanel(car,obstacles);
        frame.add(panel,new GridBagConstraints(0,0,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.BOTH,
                new Insets(2,2,2,2),0,0));
        frame.setVisible(true);
    }

}
