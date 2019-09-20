package com.udea.iotProject;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

		
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        LocalDateTime date= LocalDateTime.now();
    	System.out.println("FECHA:"+date);

    
    }
}
