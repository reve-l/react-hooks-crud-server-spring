package com.cdev.reacthookscrudserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;*/

@SpringBootApplication
public class ReactHooksCrudServer2Application {

	public static void main(String[] args) {
		SpringApplication.run(ReactHooksCrudServer2Application.class, args);
	}
	
	
	/*
	@Bean
	public WebMvcConfigurer configure() {
		return new WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry reg) {
				reg.addMapping("/*").allowedOrigins("http://localhost:8080");
			}
		};
	}

	*/
	
}
