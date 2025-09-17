package com.nt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import com.nt.controller.EmployeeOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootIocProj13MiniProjetProfiles {

	public static void main(String[] args) {
	 SpringApplication.run(BootIocProj13MiniProjetProfiles.class, args);	
	}//main

}//class
