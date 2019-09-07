package com.wjg.casclienta;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCasClient
@SpringBootApplication
public class CasClientaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasClientaApplication.class, args);
    }

}
