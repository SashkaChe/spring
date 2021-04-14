package ru.neutrino.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
