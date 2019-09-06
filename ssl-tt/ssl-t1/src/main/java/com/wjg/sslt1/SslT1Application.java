package com.wjg.sslt1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650

@SpringBootApplication
public class SslT1Application {

    public static void main(String[] args) {
        SpringApplication.run(SslT1Application.class, args);
    }

}
