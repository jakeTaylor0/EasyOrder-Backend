package com.dnd.eorderservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dnd.eorderservices.model.Customer;
import com.dnd.eorderservices.repository.CustomerRepo;

@SpringBootApplication
public class EasyOrderBackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EasyOrderBackendApplication.class, args);
	}

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public void run(String... args) throws Exception { 
		this.customerRepo.save(new Customer("John Doe", "johnDoe@email.com"));
		this.customerRepo.save(new Customer("Jane Doe", "janeDoe@email.com"));
		this.customerRepo.save(new Customer("Dexter Morgan", "dexterMorgan@email.com"));
	}

}
