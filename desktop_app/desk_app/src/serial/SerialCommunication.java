package serial;

import com.fazecast.jSerialComm.SerialPort;

public class SerialCommunication {

    public static void main(String[] args) {
        String portName = "COM16";

        SerialPort serialPort = SerialPort.getCommPort(portName);

        serialPort.setBaudRate(9600);

        if (serialPort.openPort()) {
            System.out.println("Porta serial aberta com sucesso.");
            serialPort.closePort();
            System.out.println("Porta serial fechada.");
        } else {
            System.err.println("Erro ao abrir a porta serial.");
        }
    }
}

