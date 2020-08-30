package com.demo.firebaselogin.rest;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final String welcomeMessage;

    public TestController(@Value(value = "${welcome.message}") String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    @GetMapping("/{name}")
    public String helloTest(@PathVariable("name") String name) {
        return welcomeMessage + " " + name + " a la app test";
    }

    @GetMapping("/token/{token}")
    public String verifyToken(@PathVariable("token") String token) {
        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
            return decodedToken.getUid();
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return e.getAuthErrorCode().name() + ": " + e.getMessage();
        }
    }
}
