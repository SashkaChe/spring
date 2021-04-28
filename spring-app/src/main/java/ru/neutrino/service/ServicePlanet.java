package ru.neutrino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.neutrino.dao.JpaRepoPlanet;
import ru.neutrino.model.Planet;

@Component
public class ServicePlanet {

	@Autowired
	private JpaRepoPlanet jpaplanet;

	public Planet newPlanet(String name) {
		return new Planet(name);
	}

	public void showallPlanet() {
		for (Planet x : jpaplanet.findAll()) {
			System.out.println(x);
		}
	}

}
