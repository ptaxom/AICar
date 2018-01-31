package ru.Writers;

import ru.ai.net.Net;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FaultWriter {


    public static void Write(Net net, double fault) {
        String path = "res\\"+net.getName()+"\\eps.txt";
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try(FileWriter writer = new FileWriter(file.getAbsoluteFile(),true)){
            writer.append(Double.toString(fault)+" \n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
