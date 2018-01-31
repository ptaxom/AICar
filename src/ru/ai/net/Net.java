package ru.ai.net;

import ru.Initialization.CreateDLayer;
import ru.Initialization.CreateLayer;
import ru.Initialization.CreateNeuro;
import ru.Readers.FaultReader;
import ru.Readers.Reader;
import ru.Writers.FaultWriter;
import ru.Writers.Writer;

public class Net {

    private String name;
    private Layer[] layers;
    private int count;
    private double eps;
    private double alfa;

    public Net(String name, int count, double eps, double alfa, int[] config) {
        this.name = name;
        this.count = count;
        this.eps = eps;
        this.alfa = alfa;
        layers = new Layer[count];
        for(int i = count-1; i >= 0; i--)
            layers[i] = new Layer(this,i,config[i]);
        CreateNeuro.Create(this);
        for(int i = 0; i < count-1; i++){
            CreateLayer.Create(this,i);
            CreateDLayer.Create(this,i);
        }
    }


    public Net(String name){
        this.name = name;
        Reader.ReadNet(this);
        for(int i = 0; i < count-1; i++) {
            Reader.ReadLayer(layers[i]);
            Reader.ReadDLayer(layers[i]);
        }
    }


    public String getName() {
        return name;
    }

    public Layer getLayer(int num) {
        return layers[num];
    }

    public int getCount() {
        return count;
    }

    public double getEps() {
        return eps;
    }

    public double getAlfa() {
        return alfa;
    }

    public void createLayers(int count){
        this.layers = new Layer[count];
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    public void setAlfa(double alfa) {
        this.alfa = alfa;
    }

    public void createLayer(int num,int cfg){
        layers[num] = new Layer(this,num,cfg);
    }

    public double f(double x){
        return 1/(1+Math.exp(-x));
    }


    public double derivativeF(double x){
        return Math.exp(x)/(Math.exp(x)+1)/(Math.exp(x)+1);
    }

    public double[] Activate(double[] input){
        for(int i = 0; i < input.length; i++)
            layers[0].getNeyron(i).setValue(input[i]);
        for(int i = 1; i < count; i++)
            layers[i].Activate();
        double[] output = new double[layers[count-1].getCount()];
        for(int i = 0; i < layers[count-1].getCount(); i++) {
            output[i] = layers[count - 1].getNeyron(i).getValue();
        }
      //  System.out.println("Net out: "+output[0]);
        return output;
    }

    public void Teach(double[] output){
       // System.out.println("Recomendet answer: "+output[0]);
        for(int i = 0; i < layers[count-1].getCount(); i++)
            layers[count-1].getNeyron(i).setDelta(
                    (output[i]-layers[count-1].getNeyron(i).getValue()) *
                            this.derivativeF(layers[count-1].getNeyron(i).getSum())
            );
        for(int i = count-2; i >= 0; i--)
            layers[i].Teach();
        for(int i = 0; i < count-1; i++){
            Writer.WriteWeight(layers[i]);
            Writer.WriteDWeight(layers[i]);
        }

//        FaultWriter.Write(this,(1-layers[count-1].getNeyron(0).getValue())*
//                (1-layers[count-1].getNeyron(0).getValue())
//        );
    }


    public Net() {
    }
}
