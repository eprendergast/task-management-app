package com.baeldung.taskmanagementapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.baeldung.taskmanagementapp.config.AppConfig;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(new Class[]{Application.class, AppConfig.class}, args);
		context.close();
	}

}
