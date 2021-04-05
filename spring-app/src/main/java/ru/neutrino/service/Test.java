package ru.neutrino.service;


import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.neutrino.EntityConfig;
import ru.neutrino.SpringConfig;
import ru.neutrino.dao.CountryDAO;
import ru.neutrino.dao.EntityDAO;
import ru.neutrino.model.City;
import ru.neutrino.model.Country;
import ru.neutrino.model.Planet;
import ru.neutrino.model.Res;
import ru.neutrino.model.Sputnik;
import ru.neutrino.repo.PlanetRepo;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Test {

	 public static void main(String[] args) throws SQLException {
	
		 ApplicationContext javaContext = new AnnotationConfigApplicationContext(EntityConfig.class);
		 ServicePlanet servplanet = (ServicePlanet) javaContext.getBean(ServicePlanet.class);
		 
	//	 PlanetRepo repo = (PlanetRepo) javaContext.getBean(PlanetRepo.class);
		
		 servplanet.showallPlanet();
		 
		 
/*
		 for (Planet x : repo.findAll()) {
				System.out.println(x);
			}
	*/	
		
		
		 
	 } 
}
