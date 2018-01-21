package ru.gui.mainframe.Trash;

import ru.model.rectangle.Rectangle;
import ru.util.Math.Point;

import java.awt.*;

public class MainFrame {

    public static void Nomain(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                testFrame frame = new testFrame();
                Rectangle rec2 = new Rectangle(new Point(400,400),100,200,Math.PI*43/32);
                frame.DrawSomething(rec2);
            }
        });
    }

}
