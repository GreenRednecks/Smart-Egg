import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.system.NetworkInfo;
import com.pi4j.component.lcd.LCDTextAlignment;
import com.pi4j.component.lcd.impl.GpioLcdDisplay;

public class Display {
    private final int LCD_ROW_1 = 0;
    private final int LCD_ROW_2 = 1;

    public Display(){
        System.out.println("16X2 LCD Example with Raspberry Pi using Pi4J and JAVA");

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // initialize LCD
        final GpioLcdDisplay lcd = new GpioLcdDisplay(2,    // number of row supported by LCD
                16,       // number of columns supported by LCD
                RaspiPin.GPIO_25,  // LCD RS pin
                RaspiPin.GPIO_24,  // LCD strobe pin
                RaspiPin.GPIO_23,  // LCD data bit D4
                RaspiPin.GPIO_22,  // LCD data bit D5
                RaspiPin.GPIO_21,  // LCD data bit D6
                RaspiPin.GPIO_14); // LCD data bit D7

        lcd.clear();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lcd.write(LCD_ROW_1, "WeArGenius");
        lcd.write(LCD_ROW_2, " ???");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        for (String ipAddress : NetworkInfo.getIPAddresses()){
//            System.out.println("IP Addresses      :  " + ipAddress);
//            lcd.writeln(LCD_ROW_2,ipAddress,LCDTextAlignment.ALIGN_CENTER);
//        }
    }

}
