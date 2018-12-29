import java.util.ArrayList;
import java.util.UUID;

public class Eierkarton {

    public final int anzahlEierplaetze;
    public final UUID id;
    private Aufkleber aufkleber;
    private ArrayList<Ei> eier ;


    public Eierkarton(int anzahl)  {
        this.id = UUID.randomUUID();
        this.anzahlEierplaetze = anzahl;
    }

    public ArrayList<Ei> getEier() {
        return eier;
    }



    public void setEier(ArrayList<Ei> eier) {
        this.eier = eier;
    }

    public void setAufkleber(Aufkleber aufkleber){
        this.aufkleber = aufkleber;
    }

    public boolean removeOneEgg(){
        if(eier.size() > 0 ){
            eier.remove(0);
            return true;
        }
        return false;
    }

}
