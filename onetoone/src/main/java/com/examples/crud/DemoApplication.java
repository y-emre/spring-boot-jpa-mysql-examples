package com.examples.crud;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.examples.crud.model.Computer;
import com.examples.crud.model.NetworkCard;
import com.examples.crud.repository.ComputerRepository;
import com.examples.crud.repository.NetworkCardRepository;

@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ComputerRepository computerRepository, NetworkCardRepository networkCardRepository){
		return args -> {

			NetworkCard networkCard = new NetworkCard("Qualcomn", "AR478", "15 FF 5F 87 A5 EE");
			
			//save network card
			networkCardRepository.save(networkCard);
			
			Computer computer = new Computer("Acer", "5755G", new Date(), networkCard);
			
			//save computer
			computerRepository.save(computer);
			
			System.err.println(computerRepository.findAll());
			
			//update network car
			networkCard = networkCardRepository.findById(1L).get();
			networkCard.setMacAddress("15 FF C7 87 A5 EE");
			networkCardRepository.save(networkCard);
			
			System.err.println(networkCardRepository.findById(1L));
			
			//delete network car and computer
			//First computer must be deleted, because it has fk
			computerRepository.delete(computer);
			networkCardRepository.delete(networkCard);
			
		};
	}
}
