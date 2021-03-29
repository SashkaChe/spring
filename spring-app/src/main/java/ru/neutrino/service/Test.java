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

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Test {

	 public static void main(String[] args) throws SQLException {
	     
		 ApplicationContext javaContextCountryDAO = new AnnotationConfigApplicationContext(SpringConfig.class);
		 CountryDAO objdao2 = (CountryDAO) javaContextCountryDAO.getBean(CountryDAO.class);
		
		 ApplicationContext javaContext = new AnnotationConfigApplicationContext(EntityConfig.class);
		 EntityDAO objdao = (EntityDAO) javaContext.getBean(EntityDAO.class);


		for (Planet x : objdao.showPlanet()) {
			
			System.out.println(x);
		}
		 
	 } 
}
