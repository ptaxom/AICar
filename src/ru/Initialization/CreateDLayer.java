package ru.Initialization;

import ru.ai.net.Net;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateDLayer {
    public static void Create(Net net, int num){
        String path = "res\\"+net.getName();
        File cfg = new File(path+"\\d"+num+".txt");
        try(FileWriter writer = new FileWriter(cfg.getAbsoluteFile(),false)) {
            if (!cfg.exists())
                cfg.createNewFile();

            for(int i = 0; i <net.getLayer(num).getCount(); i++){
                String buf = "";
                for(int j = 0; j < net.getLayer(num+1).getCount(); j++){
                    buf+="0 ";
                }
                buf+="\n";
                writer.write(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
