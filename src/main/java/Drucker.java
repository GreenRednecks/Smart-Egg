import com.google.zxing.WriterException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Drucker {

    private Aufkleber aufkleber;
    private QRCodeGenerator qr = new QRCodeGenerator();

    public void setAufkleber(Aufkleber aufkleber) {
        this.aufkleber = aufkleber;
    }

    public void print(int anz) {   //hier muss die Anbindung an den echten Drucker rein, da etikett wird entsprechtend der anz mehrfach gedruckt


        for (int i = 0; i < anz; i++) {
            System.out.println("--------------------------------------------------------------");
            System.out.println(aufkleber.getDrucktext());
            System.out.println("--------------------------------------------------------------");
        }


    }

    public void print(Aufkleber aufkleber) {
        System.out.println("--------------------------------------------------------------");
        System.out.println(aufkleber.getDrucktext());
        System.out.println("--------------------------------------------------------------");
//        generateQR(aufkleber);
    }
    public void printOnPrinter(Aufkleber aufkleber) {

        String printText = "----------------\n"+aufkleber.getDrucktext()+"\n"+"----------------"+"\n "+"\n "+"\n ";

        String[] commands = printText.split("\n");

//        for (String command: commands){
//            System.out.println(command);
//        }




        String tmp;
        String s = new String();
        Process p;
        try {
            p = Runtime.getRuntime().exec(new String[]{"bash", "-c", "stty -F /dev/serial0 19200"});
            for (String command: commands){
                Thread.sleep(100);
                p = Runtime.getRuntime().exec(new String[]{"bash", "-c", "echo -e "+ command+" > /dev/serial0"});
            }
//            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
////            while ((tmp = br.readLine()) != null)
////                System.out.println("[LINE]: " + tmp);
////            s += tmp + "\n";
////            p.waitFor();
////            System.out.println ("[EXIT]: " + p.exitValue());
            p.destroy();
        } catch (Exception e) {}


    }



    private void generateQR(Aufkleber aufkleber) {
        try {
            qr.generateQRCodeImage(aufkleber.getKartonID().toString(), 350, 350, QRCodeGenerator.QR_CODE_IMAGE_PATH+aufkleber.getKartonID().toString()+".png");
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
    }


}
