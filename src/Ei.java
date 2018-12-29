import java.util.Date;
import java.util.UUID;

public class Ei {


    public final UUID id;
    private Date legedatum;
    private Date haltbarkeitGekuehlt;
    private Date haltbarkeitUnGekuehlt;

    public Ei (Date legedatum, Date haltbarkeitGekuehlt, Date haltbarkeitUnGekuehlt){
        this.id = UUID.randomUUID();
        this.legedatum = legedatum;
        this.haltbarkeitGekuehlt = haltbarkeitGekuehlt;
        this.haltbarkeitUnGekuehlt = haltbarkeitUnGekuehlt;
    }


    public Date getLegedatum(){
        return legedatum;
    }

    public Date getHaltbarkeitGekuehlt() {
        return haltbarkeitGekuehlt;
    }

    public Date getHaltbarkeitUnGekuehlt() {
        return haltbarkeitUnGekuehlt;
    }
}
