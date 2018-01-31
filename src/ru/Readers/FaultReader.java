package ru.Readers;

import ru.ai.net.Net;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FaultReader {

    public static List<Double> Read(Net net){
        String path = "res\\"+net.getName()+"eps.txt";
        List<Double> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String s;
            while ( (s = reader.readLine()) != null)
                list.add(Double.parseDouble(s.trim()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
