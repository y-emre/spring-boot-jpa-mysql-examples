package com.examples.crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			
			List<String> phones1 = new ArrayList<>();
			phones1.add("555 555 5555");
			phones1.add("000 000 0000");
			
			List<String> phones2 = new ArrayList<>();
			phones2.add("111 111 1111");
			
			Map<String, Car> cars1 = new HashMap<>();
			cars1.put("06 YE 1994", new Car("Renault", "Clio", "White"));
			cars1.put("06 YE 1995", new Car("Renault", "Megane", "Gray"));
			
			Map<String, Car> cars2 = new HashMap<>();
			cars2.put("34 YE 1994", new Car("Renault", "Symbol", "Gray"));
			
			//save
			personRepository.save(new Person("Yunus", "Emre", 24, phones1, cars1));
			
			personRepository.save(new Person("Yusuf", "Erkut", 23, phones2, cars2));

			//find all
			System.err.println("find all - " + personRepository.findAll());
			
			//find by id
			System.err.println("find by id - " + personRepository.findById(1L));
			
			//find by name
			System.err.println("find by name - " + personRepository.findByName("Yunus"));
			
			//find by age
			System.err.println("find by age - " + personRepository.findByAge(24));
			
			//update
			Person person = personRepository.findById(1L).get();
			phones1.add("888 888 8888");
			person.setPhones(phones1);		System.err.println("***");
			personRepository.save(person);
			System.err.println("find by name - " + personRepository.findByName("Yunus"));
			
			//find all
			System.err.println(personRepository.findAll());
			
			//delete by id
			personRepository.deleteById(1L);
			System.err.println(personRepository.findAll());
			
			//delete by object
			person = personRepository.findById(2L).get();
			personRepository.delete(person);
			System.err.println(personRepository.findAll());
			
		};
	}
}
