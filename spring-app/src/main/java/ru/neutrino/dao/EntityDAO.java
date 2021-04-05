package ru.neutrino.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.neutrino.model.Country;
import ru.neutrino.model.Planet;
import ru.neutrino.model.Sputnik;
import ru.neutrino.repo.PlanetRepo;

@Transactional
@Repository
public class EntityDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private PlanetRepo planetrepo;
	
	
	@Transactional(readOnly=true)
	public List<Planet> allPlanets() throws SQLException {
		return entityManager.createQuery("select c from Planet c").getResultList();
			}

	
	@Transactional(readOnly=true)
	public List<Sputnik> allSputniks() throws SQLException {
		return entityManager.createQuery("select c from Sputnik c").getResultList();
			}
	

	@Transactional(readOnly=true)
	public Planet findPlanetById(int id) throws SQLException {
		return (Planet) entityManager.createQuery("select c from Planet c where c.id = :id").setParameter("id", id).getSingleResult();
			}
	
	

	public Planet savePlanet(Planet planet) { 
					
		if (planet.getId() == 0) { 
		 System.out.println("Запись");
			entityManager.persist(planet);
		}
		
		else { 
			System.out.println("Обновление");
			entityManager.merge(planet); 
		
		}
		return planet; 
	
	}
	
	
	
	
	
	public void deletePlanet(Planet planet) { 
		Planet mergedPlanet = entityManager.merge(planet); 
		entityManager.remove(mergedPlanet);
	}

}
