import Huehner.Bielefelder;
import Huehner.Hahn;
import Huehner.Huhn;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class HuenherStall {



    ArrayList<Huhn> huehner = new ArrayList();
    final Lager lager = new Lager();
    final Drucker drucker = new Drucker();
    //initialize Keypad
    KeyPad keypad = new KeyPad();
    Display display = new Display();

    final String[] input = {""};

    boolean stateEntering = false;
    boolean statePrinting = false;

    public HuenherStall(){
        init();
    }


    private void init(){

        //read from memory


        keypad.addChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                switch ((char)evt.getNewValue()){
                    case '0':
                        if(stateEntering){
                            input[0] += "0";
                            render(input[0], 1);
                            System.out.println("0");
                        }
                        break;
                    case '1':
                        if(stateEntering){
                            input[0] += "1";
                            render(input[0], 1);
                            System.out.println("1");
                        }
                        break;
                    case '2':
                        if(stateEntering){
                            input[0] += "2";
                            render(input[0], 1);
                            System.out.println("2");
                        }
                        break;
                    case '3':
                        if(stateEntering){
                            input[0] += "3";
                            render(input[0], 1);
                            System.out.println("3");
                        }
                        break;
                    case '4':
                        if(stateEntering){
                            input[0] += "4";
                            render(input[0], 1);
                            System.out.println("4");
                        }
                        break;
                    case '5':
                        if(stateEntering){
                            input[0] += "5";
                            render(input[0], 1);
                            System.out.println("5");
                        }
                        break;
                    case '6':
                        if(stateEntering){
                            input[0] += "6";
                            render(input[0], 1);
                            System.out.println("6");
                        }
                        break;
                    case '7':
                        if(stateEntering){
                            input[0] += "7";
                            render(input[0], 1);
                            System.out.println("7");
                        }
                        break;
                    case '8':
                        if(stateEntering){
                            input[0] += "8";
                            render(input[0], 1);
                            System.out.println("8");
                        }
                        break;
                    case '9':
                        if(stateEntering){
                            input[0] += "9";
                            render(input[0], 1);
                            System.out.println("9");
                        }
                        break;
                    case 'A':
                        if(!statePrinting){
                            stateEntering = true;
                            input[0] = "";
                            render("Eing. best.  (#)", 0);
                            render(input[0], 1);
                            System.out.println("reset input");
                        }
                        break;
                    case 'B':
                        if(!stateEntering){
                            statePrinting = true;
                            System.out.println("printing");
                            render("Printing...", 0);
                            render("", 1);
                            drucker.printOnPrinter(lager.getAufkleber().get(lager.getAufkleber().size()-1));
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            resetDisplay();
                            statePrinting = false;
                        }
                        break;
                    case 'C':
                        if(stateEntering && input[0].length() > 0){
                            input[0] = input[0].substring(0, input[0].length()-1);
                            render(input[0], 1);
                            System.out.println("C");
                        }
                        break;
                    case 'D':
                        System.out.println("D");
                        resetDisplay();
                        break;
                    case '#':
                        if(stateEntering){
                            stateEntering = false;
                            System.out.println("eingegeben: "+input[0]);
                            if(input[0].length() <= 4){
                                lager.add(Integer.parseInt(input[0]));
                                render("Gespeichert!", 0);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            else{
                                render("Falsche Eingabe!", 0);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            resetDisplay();
                        }
                        break;
                    case '*':
                        System.out.println("*");
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void render(String s, int row){
        if(!display.print(s, row)) resetDisplay();
    }



    private void resetDisplay(){
        render("Eing. Eier   (A)", 0);
        render("Bon drucken  (B)", 1);
        stateEntering = false;
        statePrinting = false;
    }


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

    public void inputValue(char c){

    }





    public static void main(String[] args){
        HuenherStall huenerstall = new HuenherStall();

//test





//        lager.add(33);
//
//        drucker.printOnPrinter(lager.getAufkleber().get(lager.getAufkleber().size()-1));

        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


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
