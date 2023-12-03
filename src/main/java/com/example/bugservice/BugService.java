package com.example.bugservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BugService {

	public static void main(String[] args) {

		System.out.println("bugService");
		SpringApplication.run(BugService.class, args);
	}
}
