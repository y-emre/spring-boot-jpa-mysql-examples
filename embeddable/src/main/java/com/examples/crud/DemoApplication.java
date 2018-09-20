package com.examples.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.examples.crud.model.Car;
import com.examples.crud.model.Person;
import com.examples.crud.repository.PersonRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PersonRepository personRepository){
		return args -> {
			
			//save
			personRepository.save(new Person("Yunus", "Emre", 24, new Car("Renault", "Clio", "White")));
			personRepository.save(new Person("Yusuf", "Erkut", 23, new Car("Renault", "Megane", "Gray")));

			//find all
			System.err.println(personRepository.findAll());
			
		};
	}
}
