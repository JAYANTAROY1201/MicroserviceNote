package com.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="note_service")
@EnableFeignClients("com.todo")
public class ToDoMicroserviceNoteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoMicroserviceNoteServiceApplication.class, args);
	}
}
