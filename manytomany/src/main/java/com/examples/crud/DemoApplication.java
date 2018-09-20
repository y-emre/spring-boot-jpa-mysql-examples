package com.examples.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.examples.crud.model.Department;
import com.examples.crud.model.Firm;
import com.examples.crud.repository.DepartmentRepository;
import com.examples.crud.repository.FirmRepository;

@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(FirmRepository firmRepository, DepartmentRepository departmentRepository){
		return args -> {

			//save
			Department d1 = new Department("IT");
			Department d2 = new Department("SALES");
			
			Firm f1 = new Firm("google");
			Firm f2 = new Firm("apple");
			
			d1.getFirms().add(f1);
			d1.getFirms().add(f2);
			
			d2.getFirms().add(f1);
			d2.getFirms().add(f2);
			
			f1.getDepartments().add(d1);
			
			f1.getDepartments().add(d2);
			
			firmRepository.save(f1);
			firmRepository.save(f2);
			
			System.err.println(firmRepository.findAll());
			
			
		};
	}
}
