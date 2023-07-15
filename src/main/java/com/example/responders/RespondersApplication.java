package com.example.responders;

import com.example.arduino.ArduinoData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class RespondersApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RespondersApplication.class, args);
        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
        System.out.println(encoder.encode("pass"));
//        ArduinoData arduinoDate = new ArduinoData();
//        arduinoDate.portL();

    }

}
