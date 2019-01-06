import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Lager {
    private ArrayList<Eierkarton> lagerLeereKartons6;
    private ArrayList<Eierkarton> lagerLeereKartons10;
    private ArrayList<Eierkarton> lagerVolleKartons; //an spätere Datenbankanbindung denken
    private ArrayList<Eierkarton> ausgelieferteKartons;
    private Drucker drucker = new Drucker();

    public Lager() {
        //hier Datenbankobjekte einlesen danach

        lagerVolleKartons = new ArrayList();
        lagerLeereKartons6 = new ArrayList();
        lagerLeereKartons10 = new ArrayList();
        ausgelieferteKartons = new ArrayList();

    }


    public void addLeereKartons6(int anz){
        for (int i = 0; i < anz; i++){
            lagerLeereKartons6.add(new Eierkarton(6));
        }
    }
    public void addLeereKartons10(int anz){
        for (int i = 0; i < anz; i++){
            lagerLeereKartons10.add(new Eierkarton(10));
        }
    }


    public int getAnzLeereKartons6(){
        return lagerLeereKartons6.size();
    }
    public int getAnzLeereKartons10(){
        return lagerLeereKartons10.size();
    }
    public int getAnzVolleKartons(){
        return lagerVolleKartons.size();
    }

    private ArrayList<Ei> createEggs(int anz){

        ArrayList<Ei> eier = new ArrayList();
        Date d = new Date();
        Calendar calender = Calendar.getInstance();

        calender.setTime(d);
        calender.add(Calendar.DAY_OF_YEAR, 21);
        Date haltbarkeitUnGekuehlt = calender.getTime();
        calender.add(Calendar.DAY_OF_YEAR, 21);
        Date haltbarkeitGekuehlt = calender.getTime();


        for (int i=0;i < anz; i++){
            eier.add(new Ei(d, haltbarkeitGekuehlt, haltbarkeitUnGekuehlt));
        }

        return eier;
    }




    public void add(int anzEier){
        ArrayList<Ei> eier = createEggs(anzEier);

        int loopcounter = 0;
        while (eier.size() > 0) {       //eier erstellen und in kartons einsortieren

            if (eier.size() <= 6) {
                Eierkarton e = lagerLeereKartons6.get(0);
                e.setEier(eier);
                lagerVolleKartons.add(e);
                lagerLeereKartons6.remove(0);
                break;
            } else if (eier.size() >= 6 && eier.size() <= 10) {
                Eierkarton e = lagerLeereKartons10.get(0);
                e.setEier(eier);
                lagerVolleKartons.add(e);
                lagerLeereKartons10.remove(0);
                break;
            }
            else if(eier.size() > 10 && eier.size() % 6 == 0){
                Eierkarton e = lagerLeereKartons6.get(0);
                e.setEier(new ArrayList<Ei>(eier.subList(0, 6)));
                lagerVolleKartons.add(e);
                lagerLeereKartons6.remove(0);
                eier = new ArrayList<>(eier.subList(6, eier.size()) );
            }
            else  {
                Eierkarton e = lagerLeereKartons10.get(0);
                e.setEier(new ArrayList<Ei>(eier.subList(0, 10)));
                lagerVolleKartons.add(e);
                lagerLeereKartons10.remove(0);
                eier = new ArrayList<>(eier.subList(10, eier.size()) );
            }
            loopcounter ++;
        }




        for (int i = lagerVolleKartons.size()-1; loopcounter >= 0; i--, loopcounter--){   //Etiketten ausdrucken
            drucker.print(lagerVolleKartons.get(i).getAufkleber());
        }



    }


    public void checkout(){ //hier gucken, wie mann einen QR Code scanner mit der UUID verknüpft

    }

}
