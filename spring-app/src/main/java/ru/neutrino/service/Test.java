package ru.neutrino.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.neutrino.EntityConfig;

import java.sql.SQLException;



public class Test {

	 public static void main(String[] args) throws SQLException {
	
		 ApplicationContext javaContext = new AnnotationConfigApplicationContext(EntityConfig.class);
		 ServicePlanet servplanet = (ServicePlanet) javaContext.getBean(ServicePlanet.class);

		 servplanet.showallPlanet();

	 } 
}
