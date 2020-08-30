package com.demo.firebaselogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FirebaseLogin extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FirebaseLogin.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FirebaseLogin.class);
    }
}
