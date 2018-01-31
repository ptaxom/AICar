package ru.Initialization;

import ru.ai.net.Net;

import java.io.*;

public class CreateNeuro {

    public static void Create(Net net){
        String dir = "res\\"+net.getName();
        File folder = new File(dir);
        if (!folder.exists())
            folder.mkdir();
        File cfgFile = new File(dir+"\\cfg.txt");
        try (FileWriter writer = new FileWriter(cfgFile.getAbsoluteFile(), false)){
            if (!cfgFile.exists())
                cfgFile.createNewFile();
            writer.write(Double.toString(net.getAlfa())+"\n");
            writer.write(Double.toString(net.getEps())+"\n");
            writer.write(Integer.toString(net.getCount())+"\n");
            String buf = "";
            for(int i = 0; i < net.getCount(); i++)
                buf+=net.getLayer(i).getCount()+" ";
            writer.write(buf);


            } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
