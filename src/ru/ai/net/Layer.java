package ru.ai.net;

public class Layer {

    private Net net;
    private int number;
    private int count;
    private Neyron[] neyron;

    public Layer(Net net, int number, int count) {
        this.net = net;
        this.number = number;
        this.count = count;
        neyron = new Neyron[count];
        for(int i = 0; i < count; i++)
            neyron[i] = new Neyron(i,this);
    }

    public Net getNet() {
        return net;
    }

    public void setNet(Net net) {
        this.net = net;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Neyron getNeyron(int num){
        return neyron[num];
    }

    public void Activate() {
        for(int i = 0; i < count; i++)
            neyron[i].Activate();
    }

    public void Teach() {
        for(int i = 0; i < count; i++) {
            neyron[i].calcDelta();
            neyron[i].Teach();
        }
    }
}
