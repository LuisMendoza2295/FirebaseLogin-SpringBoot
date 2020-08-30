package com.demo.firebaselogin.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    private final String firebaseDatabaseUrl;

    public FirebaseConfig(@Value("${firebase.database.url}") String firebaseDatabaseUrl) {
        this.firebaseDatabaseUrl = firebaseDatabaseUrl;
    }

    @PostConstruct
    public void init() throws IOException {
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setDatabaseUrl(firebaseDatabaseUrl)
                .build();

        FirebaseApp.initializeApp(options);
    }
}
