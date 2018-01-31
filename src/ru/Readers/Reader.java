package ru.Readers;

import ru.ai.net.Layer;
import ru.ai.net.Net;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    public static void ReadLayer(Layer layer){
        String path = "res\\"+layer.getNet().getName()+"\\"+layer.getNumber()+".txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String s = "";
            int cnt = 0;
            while ( (s = reader.readLine()) != null){
                String values[] = s.split(" ");
                for(int i = 0; i < layer.getNet().getLayer(layer.getNumber()+1).getCount(); i++)
                    layer.getNeyron(cnt).setWeight(Double.parseDouble(values[i]),i);
                cnt++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void ReadDLayer(Layer layer){
        String path = "res\\"+layer.getNet().getName()+"\\d"+layer.getNumber()+".txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String s = "";
            int cnt = 0;
            while ( (s = reader.readLine()) != null){
                String values[] = s.split(" ");
                for(int i = 0; i < layer.getNet().getLayer(layer.getNumber()+1).getCount(); i++)
                    layer.getNeyron(cnt).setDWeight(Double.parseDouble(values[i]),i);
                cnt++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void ReadNet(Net net){
        String path = "res\\"+net.getName()+"\\cfg.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            net.setAlfa(Double.parseDouble(reader.readLine()));
            net.setEps(Double.parseDouble(reader.readLine()));
            net.setCount(Integer.parseInt(reader.readLine()));
            net.createLayers(net.getCount());
            String[] cfg = (reader.readLine()).split(" ");
            for(int i = net.getCount()-1; i >=0; i--)
                net.createLayer(i,Integer.parseInt(cfg[i]));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
