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
		 ServicePlanet sevplanet = (ServicePlanet) javaContext.getBean(ServicePlanet.class);
		
		 sevplanet.showallPlanet();
		 
		 /*
		  * 
		  * 
		  * 
		  objdao.deletePlanet(objdao.showPlanetId(10).get(0));
		 
		 Planet obj = new Planet();
		 obj.setPlanet("Планета");
		 objdao.savePlanet(obj);
		 
		
		 Planet obj = objdao.showPlanetId(1).get(0);
		 
		 obj.setPlanet("1111");
		 
		 objdao.savePlanet(obj);
		 		 
		 
		 for (Planet x : objdao.showPlanet()) {
			System.out.println(x);
			}
			*/
		
		
		
		
		 
	 } 
}
