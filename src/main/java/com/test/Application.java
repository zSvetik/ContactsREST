package com.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.test.entity.Contact;
import com.test.repository.ContactRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner loadData(final ContactRepository contactRepository) {
		return (args) -> {
			for (int i = 0; i < 10000; i++) {
				contactRepository.save(new Contact("Jack"));
				contactRepository.save(new Contact("Chloe"));
				contactRepository.save(new Contact("Kim"));
				contactRepository.save(new Contact("David"));
				contactRepository.save(new Contact("Michelle"));
				contactRepository.save(new Contact("Bauer"));
				contactRepository.save(new Contact("O'Brian"));
				contactRepository.save(new Contact("Bauer"));
				contactRepository.save(new Contact("Palmer"));
				contactRepository.save(new Contact("Dessler"));
			}
		};
	}

}
