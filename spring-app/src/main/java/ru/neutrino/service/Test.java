package ru.neutrino.service;


import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.neutrino.dao.CountryDAO;
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
	     
	
		
		 ApplicationContext javaContext = new AnnotationConfigApplicationContext("ru.neutrino");
	 
		 CountryDAO country = (CountryDAO) javaContext.getBean(CountryDAO.class);


		for (City x : country.showCity()) {
		System.out.println(x);
				}
		 
	 } 
}
