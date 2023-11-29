package serial;

import com.fazecast.jSerialComm.SerialPort;

public class SerialCommunication {

    private static SerialPort serialPort;

    public static void openPort() {
        if (serialPort == null || !serialPort.isOpen()) {
            String portName = "COM8";
    
            serialPort = SerialPort.getCommPort(portName);
            serialPort.setBaudRate(9600);
    
            if (serialPort.openPort()) {
                System.out.println("Porta serial aberta com sucesso.");
            } else {
                System.err.println("Erro ao abrir a porta serial.");
            }
        } else {
            System.out.println("Porta serial já está aberta.");
        }
    }

    public static void enviarComandoParaArduino(char command) {
        try {
            if (serialPort != null) {
                serialPort.getOutputStream().write(command);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closePortOnExit() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (serialPort != null && serialPort.isOpen()) {
                serialPort.closePort();
                System.out.println("Porta serial fechada.");
            }
        }));
    }
}

