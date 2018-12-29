import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Aufkleber {

    private String drucktext;
    private UUID kartonID;

    private String legedatumAlsString,ablaufdatumGekuehltAlsString, ablaufdatumUngekuehltAlsString;

    public Aufkleber(Date legedatum, Date ablaufdatumUngekuehlt, Date ablaufdatumGekuehlt) {
        DateFormat formatter = new SimpleDateFormat( "dd.MM.yyyy HH:mm" );
        legedatumAlsString = formatter.format(legedatum);
        ablaufdatumGekuehltAlsString = formatter.format(ablaufdatumGekuehlt);
        ablaufdatumUngekuehltAlsString = formatter.format(ablaufdatumUngekuehlt);
        generatePrintText();
    }

    public void setKartonID(UUID id){
        this.kartonID = id;
    }

    private void generatePrintText(){
        drucktext = String.format("Diese Eier wurden exklusiv von unseren Hühnern am %s gelegt\n " +
                "und erfreut sich über einen Verbrauch, ungtekühlt bis zum %s.\n " +
                "Wenn du die Güte hast die Eier in den Kühlschrank zu legen, dann hast du sogar bis zum %s Zeit sie zu verbrauchen.\n Dein Karton hat die ID ", legedatumAlsString, ablaufdatumUngekuehltAlsString, ablaufdatumGekuehltAlsString);
    }

    public String getDrucktext() {
        return drucktext;
    }
}

