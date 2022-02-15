package com.mt.example.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootApplication.class, args);
//		System.out.println("Beans defined are : " + Arrays.toString(context.getBeanDefinitionNames()));
	}

}
