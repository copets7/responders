package com.example.arduino;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortException;
import jssc.SerialPortList;
import org.springframework.stereotype.Component;

@Component
public class ArduinoData {

    public void connect (String portName){
        SerialPort port = new SerialPort(portName);
        try {
            port.openPort();
            port.setParams(
                    SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            port.addEventListener((SerialPortEvent event)->{
                if (event.isRXCHAR()){
                    try {
                        String s = port.readString();
                        System.out.println(s);
                    } catch (SerialPortException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (SerialPortException e) {
            throw new RuntimeException(e);
        }
    }

    public void portL(){
        ArduinoData obj = new ArduinoData();
        obj.connect("/dev/ttyUSB0");
    }
}
