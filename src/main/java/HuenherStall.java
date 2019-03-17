import Huehner.Bielefelder;
import Huehner.Hahn;
import Huehner.Huhn;

import java.util.ArrayList;

public class HuenherStall {


    private double aktuelleEierMenge = 0;

    public void getFuttermenge(ArrayList<Huhn> huehner){
        double mengeKorn = 0;
        double mengeLegemehl = 0;
        for (Huhn huhn: huehner) {
            mengeKorn += huhn.getFuttermengeKorn();
            mengeLegemehl += huhn.getFuttermengeLegemehl();
        }

        System.out.println("Menge Korn: "+ mengeKorn + " Menge Legemehl: "+mengeLegemehl);

    }

    public void getMaxEier(ArrayList<Huhn> huehner){
        double maxEier = 0;
        for (Huhn huhn: huehner){
            maxEier += huhn.getMaxEier();
        }

        System.out.println("Maximale anz an eiern "+maxEier);
    }


    public double getEierMenge(){
        return aktuelleEierMenge;
    }

    public void setAktuelleEierMenge(double menge){
        //hier die eingabe vom terminal verarbeiten
    }






    public static void main(String[] args){
        HuenherStall huenerstall = new HuenherStall();
        ArrayList<Huhn> huehner = new ArrayList();
        Lager lager = new Lager();
        Drucker drucker = new Drucker();


        lager.add(33);

        drucker.print(lager.getAufkleber().get(lager.getAufkleber().size()-1));


        /*

        for (int i = 0; i < 30; i++){  //das ist nur zu testzwecken hier, wird später durch ein eingabe terminal ausgetauscht
                    huehner.add(new Bielefelder());
                    huehner.add(new Hahn());
                    huehner.add(new Bielefelder());
        }
*/
//        lager.addLeereKartons6(10);
//        lager.addLeereKartons10(10);



//        System.out.println("test: "+ lager.getAufkleber().get(lager.getAufkleber().size()-1));

//        System.out.println("Noch " + lager.getAnzLeereKartons6()+ " 6er Kartons vorhanden");
//        System.out.println("Noch " + lager.getAnzLeereKartons10()+ " 10er Kartons vorhanden");
//        System.out.println(lager.getAnzVolleKartons()+ " volle Kartons sind im Lager");


//        huenerstall.getFuttermenge(huehner);
//        huenerstall.getMaxEier(huehner);
//      System.out.println(drucker.getKassenbong());

//      Huehner.Huhn helga = new Huehner.Henne(1.5);

    }


}
