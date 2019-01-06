package Huehner;

public class Hahn extends Huhn {

    public Hahn (){

        legtEier = false;


    }

    @Override
    public double getFuttermengeKorn() {
        return 0;
    }

    @Override
    public double getFuttermengeLegemehl() {
        return 0;
    }

    @Override
    public double getMaxEier() {
        return 0;
    }
}
