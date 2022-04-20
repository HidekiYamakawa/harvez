package com.hideki.harvez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HarvezApplication {

	public static void main(String[] args) {
		SpringApplication.run(HarvezApplication.class, args);
	}
}