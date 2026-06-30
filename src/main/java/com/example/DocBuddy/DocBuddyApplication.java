package com.example.DocBuddy;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@RequiredArgsConstructor
public class DocBuddyApplication {

//	private final NotificationService notificationService;

	public static void main(String[] args) {
		SpringApplication.run(DocBuddyApplication.class, args);
	}

}
