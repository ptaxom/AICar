package ru.gui.mainframe.panel;

import ru.Initialization.ObstaclesReader;
import ru.Readers.AimReader;
import ru.Readers.Reader;
import ru.ai.net.Net;
import ru.model.Aims;
import ru.model.Obstacles;
import ru.model.car.Car;
import ru.model.rectangle.Rectangle;
import ru.util.Math.Point;
import ru.util.Math.Vector;

import javax.swing.*;
import java.awt.*;

public class Test {


    public static void main(String[] args) {
        int[] a = {5,4,3,1};
     //   Net net = new Net("AI4",4,0.4,0.2,a);
        Net net = new Net("AI2");
        Test(net);

    }


    public static void Test(Net net){
        JFrame frame = new JFrame();
        frame.setTitle("Animation");
        frame.setSize(1000,1000);
        frame.setLayout(new GridLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Aims aims = new Aims();
        AimReader.Read(aims);
        Rectangle rectangle = new Rectangle(new Point(400,400),20,40,0);
        Car car = new Car(rectangle, new Vector(2,0),net);
        Obstacles obstacles = new Obstacles();
        obstacles = ObstaclesReader.Read();
        DrawPanel panel = new DrawPanel(car,obstacles,aims);
        frame.add(panel,new GridBagConstraints(0,0,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.BOTH,
                new Insets(2,2,2,2),0,0));
//        JTextField field = new JTextField(0);
//        field.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == 37) {
//                    car.Turn(0);
//                }
//                if (e.getKeyCode() == 39) {
//                    car.Turn(1);
//                }
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//            }
//        });
//        field.setSize(0,0);
//        panel.add(field);
        frame.setVisible(true);
     //   frame.set
    }

}
