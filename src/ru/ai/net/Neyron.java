package ru.ai.net;

import java.util.Arrays;

public class Neyron {


    private double value;
    private double delta;
    private double[] weight;
    private double[] dweight;
    private int num;
    private Layer layer;
    private double sum;

    public Neyron(int num, Layer layer) {
        this.num = num;
        this.layer = layer;
        if (layer.getNumber()+1 != layer.getNet().getCount()) {
            weight = new double[layer.getNet().getLayer(layer.getNumber() + 1).getCount()];
            dweight = new double[layer.getNet().getLayer(layer.getNumber()+ 1).getCount()];
        }
    }




    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public double getWeight(int num) {
        return weight[num];
    }

    public void setWeight(double weight,int num) {
        this.weight[num] = weight;
    }

    public double getDWeight(int num) {
        return dweight[num];
    }

    public void setDWeight(double dweight,int num) {
        this.dweight[num] = dweight;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Layer getLayer() {
        return layer;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }


    public void Activate(){
        double sum = 0;
        for(int i = 0; i < layer.getNet().getLayer(layer.getNumber()-1).getCount(); i++)
            sum+=
                    layer.getNet().getLayer(layer.getNumber()-1).getNeyron(i).getValue()
                    *
                    layer.getNet().getLayer(layer.getNumber()-1).getNeyron(i).getWeight(num);
        this.sum = sum;
        this.value = layer.getNet().f(sum);
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < layer.getNet().getLayer(layer.getNumber() + 1).getCount(); i++ )
            s+=weight[i]+" ";
        return s;
    }

    public double getSum() {
        return sum;
    }

    public void calcDelta(){
        double outputSum = 0;
        for(int i = 0; i < layer.getNet().getLayer(layer.getNumber()+1).getCount(); i++)
            outputSum+=layer.getNet().getLayer(layer.getNumber()+1).getNeyron(i).getDelta()*weight[i];
        this.delta = layer.getNet().derivativeF(sum)*outputSum;
    }

    public void Teach(){
        for(int i = 0; i < layer.getNet().getLayer(layer.getNumber()+1).getCount(); i++){
            double grad = value * layer.getNet().getLayer(layer.getNumber()+1).getNeyron(i).delta;
            dweight[i] = layer.getNet().getEps() * grad + layer.getNet().getAlfa()*dweight[i];
            weight[i]+=dweight[i];
        }
    }
}
