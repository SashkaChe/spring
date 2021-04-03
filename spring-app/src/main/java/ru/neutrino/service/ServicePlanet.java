package ru.neutrino.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.neutrino.dao.EntityDAO;
import ru.neutrino.model.Planet;

@Component
public class ServicePlanet {

	@Autowired 
	private EntityDAO entitydao;
	
	
	public Planet newPlanet() {
		return new Planet();
	}
	
	
	public void showallPlanet() throws SQLException {
		 for (Planet x : entitydao.showPlanet()) {
				System.out.println(x);
			}
		
	}
	
}
