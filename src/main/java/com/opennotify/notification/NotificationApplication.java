package com.opennotify.notification;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class NotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

	@PostConstruct
	public void initFirebase() throws IOException {
		FileInputStream serviceAccount = new FileInputStream("src/main/resources/firebaseConfig.json");
		FirebaseOptions options = FirebaseOptions.builder()
								  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
								  .build();
		
		if(FirebaseApp.getApps().isEmpty()) {
			FirebaseApp.initializeApp(options);
			System.out.println("Firebase has been initalized!");
		}
	}
}
