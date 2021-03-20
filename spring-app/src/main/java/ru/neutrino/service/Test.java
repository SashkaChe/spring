package ru.neutrino.service;


import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.neutrino.dao.CountryDAO;
import ru.neutrino.model.City;
import ru.neutrino.model.Country;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class Test {

	 public static void main(String[] args) throws SQLException {
	     
	
		
		 ApplicationContext javaContext = new AnnotationConfigApplicationContext("ru.neutrino");
	 
		 CountryDAO country = (CountryDAO) javaContext.getBean(CountryDAO.class);

		 
		 List<City> obj = country.showCity();
			for(City x : obj) {
				System.out.println(x.toString());
			}
		 
		 
		 
		 /*
		List<Country> cat = obj.myCountry();
		
		for(Country x : cat) {
			
			System.out.println(x.toString());
			
		}
		
		
		
		 
		  Solution obj = (Solution) javaContext.getBean(Solution.class);
		 Airbus air = (Airbus) javaContext.getBean("Airbus");
		
		 
		 
		 System.out.println(air.text);
		
		
		 
		Srez name = new Srez();
				 
				 
		 Advisor addobj = new DefaultPointcutAdvisor(name, new Advice());  
		 
		 ProxyFactory pf = new ProxyFactory();
		 pf.addAdvisor(addobj);
		 pf.setTarget(obj);
		
		 
		 Solution proxy = (Solution) pf.getProxy();
		 proxy.getInt(99);
		 
		 
		 
		 System.out.println(obj.getHost());
		 System.out.println(obj.getPort());
		 System.out.println(obj.getDbname());
		 System.out.println(obj.getUsername());
		 System.out.println(obj.getPassword());
		 
	    	*/
		 
		 
	    }
	
}
