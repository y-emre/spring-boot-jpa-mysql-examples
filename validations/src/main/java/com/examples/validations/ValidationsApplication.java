package com.examples.validations;

import java.util.Date;

import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.examples.validations.model.Person;
import com.examples.validations.repository.PersonRepository;

@SpringBootApplication
public class ValidationsApplication {

	private static final Validator validator;
	
	public static void main(String[] args) {
		SpringApplication.run(ValidationsApplication.class, args);
	}
					//CREATING VALIDATOR
	static {	
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        validator = factory.getValidator();
        factory.close();
    }
					//PRINT VALIDATION MESSAGE
	private static void printError (ConstraintViolation<Person> violation) {
		System.err.println(violation.getMessage());
	}
	
	@Bean
	public static CommandLineRunner demo(PersonRepository personRepository){
		return args -> {
			
			Person person = new Person("Yunus", "Emre", new Date(), "555-444-3333", "ye@gmail.com", "http://www.ye.com");

			if(validator.validate(person).isEmpty()) //IF VALID
				personRepository.save(person);
			else	//IF NOT VALID
				validator.validate(person).stream().forEach(ValidationsApplication::printError);
		};
	}
	
}
