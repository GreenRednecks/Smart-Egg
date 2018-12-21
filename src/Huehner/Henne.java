package Huehner;

public abstract class Henne extends Huhn {


    private double legeleistung;

    public Henne(double legeleistung) {
        legtEier = true;
        this.legeleistung = legeleistung;

    }


    public double getLegeleistung() {
        return legeleistung;
    }

    public abstract double getFuttermengeKorn();

    public abstract double getFuttermengeLegemehl();


}
