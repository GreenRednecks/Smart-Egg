package Huehner;

public class Legehenne extends Henne {


    public Legehenne() {
        super(1.1);
    }

    public double getFuttermengeKorn(){
        return 0.1; //100 gramm korn
    }
    public double getFuttermengeLegemehl(){
        return 0.3; //300 gramm legemehl
    }

    @Override
    public double getMaxEier() {
        return super.getLegeleistung();
    }

}
