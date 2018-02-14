package com.projet.isidis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//extends SpringBootServletInitializer
//@Configuration
//@ComponentScan
@SpringBootApplication
//@EnableAutoConfiguration
public class ProjetIsidisApplication {

	/*
	public ProjetIsidisApplication() {
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		application.sources(this.getClass());
		return super.configure(application);
	}
	*/
	public static void main(String[] args) {
		SpringApplication.run(ProjetIsidisApplication.class, args);
		System.out.println("Hello Spring ！");
	}
}
