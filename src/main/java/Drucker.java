

public class Drucker {

    private Aufkleber aufkleber;

    public void setAufkleber(Aufkleber aufkleber){
        this.aufkleber = aufkleber;
    }

    public void print(int anz){   //hier muss die Anbindung an den echten Drucker rein, da etikett wird entsprechtend der anz mehrfach gedruckt


        for (int i = 0; i < anz; i++){
            System.out.println("--------------------------------------------------------------");
            System.out.println(aufkleber.getDrucktext());
            System.out.println("--------------------------------------------------------------");
        }


    }

    public void print(Aufkleber aufkleber){
        System.out.println("--------------------------------------------------------------");
        System.out.println(aufkleber.getDrucktext());
        System.out.println("--------------------------------------------------------------");
    }

}
