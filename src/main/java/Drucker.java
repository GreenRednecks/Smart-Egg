import com.google.zxing.WriterException;

import java.io.IOException;

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
        generateQR(aufkleber);
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
