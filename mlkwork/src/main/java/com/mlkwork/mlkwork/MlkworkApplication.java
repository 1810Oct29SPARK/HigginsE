package com.mlkwork.mlkwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"beans"})
public class MlkworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(MlkworkApplication.class, args);
	}

}

