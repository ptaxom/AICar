package ru.Readers;

import ru.model.Aims;
import ru.util.Math.Point;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AimReader {

    public static void Read(Aims aims){
        String path = "res\\aims.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String s = "";
            while ( (s = reader.readLine()) != null){
                String[] k = s.split(" ");
                Point p = new Point(Double.parseDouble(k[0]), Double.parseDouble(k[1]));
                aims.Add(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
