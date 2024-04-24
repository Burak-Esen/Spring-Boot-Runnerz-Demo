package com.burakesen.restdemo;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.burakesen.restdemo.run.Location;
import com.burakesen.restdemo.run.Run;
import com.burakesen.restdemo.run.JdbcClientRunRepository;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	// @Bean // it makes the spring this class manage.
	// CommandLineRunner runner(JdbcClientRunRepository runRepository) {
	// 	return args -> {
	// 		Run run = new Run(
	// 				5,
	// 				"Fifth Run",
	// 				LocalDateTime.now(),
  //                  LocalDateTime.now().plusHours(1),
	// 				5,
	// 				Location.OUTDOOR,
	// 				0
	// 		);
	// 		runRepository.create(run);
	// 	};
	// }
}
