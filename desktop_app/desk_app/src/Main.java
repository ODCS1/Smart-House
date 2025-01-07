import javafx.application.Application;
import serial.SerialCommunication;

public class Main {
    public static void main(String[] args) {

        SerialCommunication.openPort();

        Application.launch(App.class, args);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            SerialCommunication.closePortOnExit();
        }));
    }
}
