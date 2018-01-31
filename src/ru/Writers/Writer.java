package ru.Writers;

import ru.ai.net.Layer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {


    public static void WriteWeight(Layer layer){
        String path = "res\\"+layer.getNet().getName()+"\\"+layer.getNumber()+".txt";
        File file = new File(path);
        try(FileWriter writer = new FileWriter(file.getAbsoluteFile(),false)){
            for(int i = 0; i < layer.getCount(); i++){
                String cfgs = "";
                for(int j = 0; j < layer.getNet().getLayer(layer.getNumber()+1).getCount(); j++)
                    cfgs+=layer.getNeyron(i).getWeight(j)+" ";
                cfgs+="\n";
                writer.write(cfgs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void WriteDWeight(Layer layer){
        String path = "res\\"+layer.getNet().getName()+"\\d"+layer.getNumber()+".txt";
        File file = new File(path);
        try(FileWriter writer = new FileWriter(file.getAbsoluteFile(),false)){
            for(int i = 0; i < layer.getCount(); i++){
                String cfg = "";
                for(int j = 0; j < layer.getNet().getLayer(layer.getNumber()+1).getCount(); j++)
                    cfg+=layer.getNeyron(i).getDWeight(j)+" ";
                cfg+="\n";
                writer.write(cfg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
