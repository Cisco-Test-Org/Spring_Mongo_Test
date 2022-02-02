package com.cisco.springmongodemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringMongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository){
		return  args -> {

			Address address = new Address("Sri Lanka","06000","Colombo");

			ArrayList<Object> list = new ArrayList<>();
			list.add("Computer Science");


			Student student = new Student("Rushain",
					"Sovis", "rushain@gmail.com",
					Gender.MALE, address, list, BigDecimal.TEN, LocalDateTime.now());

			repository.insert(student);
		};
	}
}
