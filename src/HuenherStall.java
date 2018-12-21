import java.util.ArrayList;

public class HuenherStall {


    public void getFuttermenge(ArrayList<Huhn> huehner){
        double mengeKorn = 0;
        double mengeLegemehl = 0;
        for (Huhn huhn: huehner) {
            mengeKorn += huhn.getFuttermengeKorn();
            mengeLegemehl += huhn.getFuttermengeLegemehl();
        }

        System.out.println("Menge Korn: "+ mengeKorn + " Menge Legemehl: "+mengeLegemehl);

    }



              public static void main(String[] args){
                HuenherStall huenerstall = new HuenherStall();
                ArrayList huehner = new ArrayList<Huhn>();

                for (int i = 0; i < 30; i++){  //das muss aber variabel sein..
                    huehner.add(new Bielefelder(1.5));
                    huehner.add(new Hahn());
                    huehner.add(new Bielefelder(1.2));


        }

        huenerstall.getFuttermenge(huehner);



//        Huhn helga = new Henne(1.5);

    }


}
