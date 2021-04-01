package ru.neutrino.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.neutrino.model.Country;
import ru.neutrino.model.Planet;
import ru.neutrino.model.Sputnik;

@Transactional
@Repository
public class EntityDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Transactional(readOnly=true)
	public List<Planet> showPlanet() throws SQLException {
		return entityManager.createQuery("select c from Planet c").getResultList();
		
		// select distinct c from Planet c left join fetch c.sputnik
			}

	@Transactional(readOnly=true)
	public List<Sputnik> showSputnik() throws SQLException {
		return entityManager.createQuery("select c from Sputnik c").getResultList();
			}
	
	
	
	@Transactional(readOnly=true)
	public List<Planet> showPlanetId(int id) throws SQLException {
		return entityManager.createQuery("select c from Planet c where c.id = :id").setParameter("id", id).getResultList();
			}
	
	
	@Transactional
	public Planet savePlanet(Planet planet) { 
					
		
		if (planet.getId() == 0) { 
		 System.out.println("Запись");
			entityManager.persist(planet);
			entityManager.flush();
			
		}
		
		else { 
			System.out.println("Обновление");
			entityManager.merge(planet); 
		    entityManager.flush();
		}
		return planet; 
	
	}
	

}
