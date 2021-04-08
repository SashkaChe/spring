package ru.neutrino.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.neutrino.dao.EntityDAO;
import ru.neutrino.dao.JpaRepoPlanet;
import ru.neutrino.model.Planet;

@Component
public class ServicePlanet {

	@Autowired 
	private JpaRepoPlanet entitydao;
	
	// private EntityDAO entitydao;
	
		
	
	public Planet newPlanet(String name) {
      return new Planet (name);
	}
	
	
	public void showallPlanet() throws SQLException {
		 for (Planet x : entitydao.findAll()) {
				System.out.println(x);
			}
	}
		 
		 
		 
	}
	

