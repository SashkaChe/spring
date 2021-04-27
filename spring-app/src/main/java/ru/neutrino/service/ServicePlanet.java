package ru.neutrino.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import ru.neutrino.dao.JpaRepoPlanet;
import ru.neutrino.model.Planet;

@Component
public class ServicePlanet {

	@Autowired
	private JpaRepoPlanet jpaplanet;

	@Autowired
	private ConversionService conversionService;

	public Planet newPlanet(String name) {
		return new Planet(name);
	}

	public void showallPlanet() {
		for (Planet x : jpaplanet.findAll()) {
			System.out.println(x);
		}
	}

	public Set<String> convers(List<String> obj) {
		return conversionService.convert(obj, HashSet.class);
	}

}
