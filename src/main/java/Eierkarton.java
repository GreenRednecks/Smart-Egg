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
        createAufkleber();
    }

    private void createAufkleber(){
        aufkleber = new Aufkleber(eier.get(0).getLegedatum(), eier.get(0).getHaltbarkeitUnGekuehlt(),eier.get(0).getHaltbarkeitGekuehlt(), this.id, this.eier.size(), anzahlEierplaetze);
    }

    public Aufkleber getAufkleber() {
        return aufkleber;
    }

    public boolean removeOneEgg(){
        if(eier.size() > 0 ){
            eier.remove(0);
            return true;
        }
        return false;
    }

}
