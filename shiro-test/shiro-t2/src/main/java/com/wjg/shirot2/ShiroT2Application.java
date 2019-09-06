package com.wjg.shirot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wjg")
public class ShiroT2Application {

    public static void main(String[] args) {
        SpringApplication.run(ShiroT2Application.class, args);
    }

}
