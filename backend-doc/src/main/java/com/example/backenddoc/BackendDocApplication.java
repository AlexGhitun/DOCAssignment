package com.example.backenddoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.backenddoc.entity")
public class BackendDocApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendDocApplication.class, args);
    }

}
