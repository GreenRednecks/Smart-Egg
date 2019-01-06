package Huehner;

public class Bielefelder extends Henne {


    public Bielefelder() {
        super(0.8);
    }

    public double getFuttermengeKorn(){
        return 0.2; //200 gramm korn
    }
    public double getFuttermengeLegemehl(){
        return 0.6; //600 gramm legemehl
    }

    @Override
    public double getMaxEier() {
        return super.getLegeleistung();
    }


}
