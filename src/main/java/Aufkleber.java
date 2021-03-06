import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Aufkleber {

    private String drucktext;
    private UUID kartonID;
    private int anzEier;
    private  int anzEierplaetze;

    private String legedatumAlsString,ablaufdatumGekuehltAlsString, ablaufdatumUngekuehltAlsString;

    public Aufkleber(Date legedatum, Date ablaufdatumUngekuehlt, Date ablaufdatumGekuehlt, UUID kartonID, int anzEier, int anzEierplaetze) { //aufkleber für eierkartons
        DateFormat formatter = new SimpleDateFormat( "dd.MM.yyyy" );
        legedatumAlsString = formatter.format(legedatum);
        ablaufdatumGekuehltAlsString = formatter.format(ablaufdatumGekuehlt);
        ablaufdatumUngekuehltAlsString = formatter.format(ablaufdatumUngekuehlt);
        this.kartonID = kartonID;
        this. anzEier = anzEier;
        this.anzEierplaetze = anzEierplaetze;
        generatePrintTextBox();
    }

    public Aufkleber(Date legedatum, Date ablaufdatumUngekuehlt, Date ablaufdatumGekuehlt, int anzEier){     //aufkleber für eier
        DateFormat formatter = new SimpleDateFormat( "dd.MM.yyyy" );
        legedatumAlsString = formatter.format(legedatum);
        ablaufdatumGekuehltAlsString = formatter.format(ablaufdatumGekuehlt);
        ablaufdatumUngekuehltAlsString = formatter.format(ablaufdatumUngekuehlt);
        this. anzEier = anzEier;
        generatePrintTextEgg();
    }

    private void generatePrintTextBox(){
        drucktext = "Legedatum: "+ legedatumAlsString + "\n" + "Haltbar ungekuehlt: " + ablaufdatumUngekuehltAlsString+"\n" + "Haltbar gekuehlt: "+ ablaufdatumGekuehltAlsString+"\n"+ "Enthaltene Eier: "+anzEier+ "/" +anzEierplaetze+"\n"+ "ID: "+ kartonID.toString();

//        drucktext = String.format("Diese Eier wurden exklusiv von unseren Hühnern am %s gelegt\n " +
//                "und erfreut sich über einen Verbrauch, ungtekühlt bis zum %s.\n " +
//                "Wenn du die Güte hast die Eier in den Kühlschrank zu legen, dann hast du sogar bis zum %s Zeit sie zu verbrauchen.\n Dein Karton hat die ID ", legedatumAlsString, ablaufdatumUngekuehltAlsString, ablaufdatumGekuehltAlsString);
    }
    private void generatePrintTextEgg(){
        drucktext = "Heute wurden "+ this.anzEier + " Eier gelegt\n"+"Legedatum: "+ legedatumAlsString + "\n" + "Haltbar ungekuehlt: " + ablaufdatumUngekuehltAlsString+"\n" + "Haltbar gekuehlt: "+ ablaufdatumGekuehltAlsString;

//        drucktext = String.format("Diese Eier wurden exklusiv von unseren Hühnern am %s gelegt\n " +
//                "und erfreut sich über einen Verbrauch, ungtekühlt bis zum %s.\n " +
//                "Wenn du die Güte hast die Eier in den Kühlschrank zu legen, dann hast du sogar bis zum %s Zeit sie zu verbrauchen.\n Dein Karton hat die ID ", legedatumAlsString, ablaufdatumUngekuehltAlsString, ablaufdatumGekuehltAlsString);
    }

    public String getDrucktext() {
        return drucktext;
    }
    public UUID getKartonID(){
        return kartonID;
    }
}

