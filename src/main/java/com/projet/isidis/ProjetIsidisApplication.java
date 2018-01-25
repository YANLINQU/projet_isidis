package com.projet.isidis;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
extends SpringBootServletInitializer
@Configuration
@ComponentScan
@EnableAutoConfiguration
*/
@SpringBootApplication
public class ProjetIsidisApplication  {

	/*
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
