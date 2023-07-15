package com.example.arduino;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortException;
import org.springframework.stereotype.Component;

@Component
public class ArduinoData {

    public String connect(String portName) {
        SerialPort port = new SerialPort(portName);
        StringBuffer buffer = new StringBuffer();
        try {
            port.openPort();
            port.setParams(
                    SerialPort.BAUDRATE_4800,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            port.addEventListener((SerialPortEvent event) -> {
                if (event.isRXCHAR()) {
                    try {
                        String s = port.readString();
                        buffer.append(s);
                        System.out.print(s);
                    } catch (SerialPortException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (SerialPortException e) {
            throw new RuntimeException(e);
        }
        return buffer.toString();
    }

    public void portL() {
        ArduinoData obj = new ArduinoData();
        obj.connect("/dev/ttyUSB0");
    }
}
