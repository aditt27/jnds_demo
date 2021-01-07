package com.adibu.training.jnds_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationHome;

import id.co.nds.core.config.Environtment;

@SpringBootApplication
public class JndsDemoApplication {

	public static void main(String[] args) {

		//Setup JNDS
		ApplicationHome home= new ApplicationHome(JndsDemoApplication.class);
		Environtment.setup(home.getDir().getAbsolutePath());

		SpringApplication.run(JndsDemoApplication.class, args);
	}

}
