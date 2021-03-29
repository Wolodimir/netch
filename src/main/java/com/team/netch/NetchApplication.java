package com.team.netch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class NetchApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetchApplication.class, args);
    }

}
