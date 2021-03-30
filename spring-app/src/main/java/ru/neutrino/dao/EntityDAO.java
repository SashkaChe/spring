package ru.neutrino.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.neutrino.model.Country;
import ru.neutrino.model.Planet;

@Transactional
@Repository
public class EntityDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Transactional(readOnly=true)
	public List<Planet> showPlanet() throws SQLException {
		return entityManager.createQuery("select c from Planet c").getResultList();
			}

}
