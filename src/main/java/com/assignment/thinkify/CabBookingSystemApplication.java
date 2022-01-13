package com.assignment.thinkify;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("{com.assignment}")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CabBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabBookingSystemApplication.class, args);

	}

}
