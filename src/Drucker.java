import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Drucker {

    private Date aktuellesDatum;
    private Calendar calender = Calendar.getInstance();



    private Date haltbarkeitGekuehlt; //aktuelles Datum + 3 woche ungekuehlt 6 Wochen Gekuehlt
    private Date haltbarkeitUnGekuehlt; //aktuelles Datum + 3 woche ungekuehlt 6 Wochen Gekuehlt

    public String getKassenbong(){
        aktuellesDatum = new Date();
        calender.setTime(aktuellesDatum);
        calender.add(Calendar.DAY_OF_YEAR, 21);
        haltbarkeitUnGekuehlt = calender.getTime();
        calender.add(Calendar.DAY_OF_YEAR, 21);
        haltbarkeitGekuehlt = calender.getTime();

        DateFormat formatter = new SimpleDateFormat( "dd.MM.yyyy HH:mm" );
        String aktuellesDatumAlsString = formatter.format(aktuellesDatum);
        String gekuehltDatumAlsString = formatter.format(haltbarkeitGekuehlt);
        String unGekuehltDatumAlsString = formatter.format(haltbarkeitUnGekuehlt);



        return String.format("Dieser Karton wurde exklusiv von unseren Hühnern am %s gelegt\n " +
                "und erfreut sich über einen Verbrauch, ungtekühlt bis zum %s.\n " +
                "Wenn du die güte hast die Eier in den Kühlschrank zu lege, dann hast du bist zum %s Zeil.", aktuellesDatumAlsString, unGekuehltDatumAlsString,gekuehltDatumAlsString);
    }

}
