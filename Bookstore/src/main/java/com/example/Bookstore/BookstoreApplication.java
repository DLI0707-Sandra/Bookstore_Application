package com.example.Bookstore;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BookstoreApplication {
	private static final Logger logger = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(BookstoreApplication.class, args);
		log.info("info level");
	}
}
