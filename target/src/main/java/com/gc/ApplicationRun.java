package com.gc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.gc.model.selection.InstrumentSelection;

@SpringBootApplication//(exclude = SecurityAutoConfiguration.class)
public class ApplicationRun {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationRun.class, args); 
		
	}
}
