package ru.neutrino.dao;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import ru.neutrino.model.*;

import org.hibernate.SessionFactory;


@Transactional
@Repository 
public class CountryDAO  {


	@Resource
	private SessionFactory sessionFactory;

	
   @Transactional(readOnly=true)
	public List<Country> showCountry() {
		return sessionFactory.getCurrentSession().createQuery("select distinct c from Country c left join fetch c.res").list();
			}

   @Transactional(readOnly=true)
  	public Country showCountryId(long id) {
  		return (Country) sessionFactory.getCurrentSession().createQuery("select c from Country c left join fetch c.res where c.id = :id").setParameter("id", id).uniqueResult();
  	}

   
 	public Country saveCountry(Country obj) {
 		 sessionFactory.getCurrentSession().saveOrUpdate(obj);
 		 return obj;
 	}
  
 	public void deleteCountry(Country obj) { 
 	sessionFactory.getCurrentSession().delete(obj); 
 	 	}

   @Transactional(readOnly=true)
	public List<City> showCity() {
		return sessionFactory.getCurrentSession().createQuery("select c from City c join fetch c.country t").list();
}
   
   @Transactional(readOnly=true)
	public City showCityId(int id) {
		return (City) sessionFactory.getCurrentSession().createQuery("select c from City c where c.id = :id").setParameter("id", id).uniqueResult();
		
	}
   
   public City saveCity(City obj)  {
		 sessionFactory.getCurrentSession().saveOrUpdate(obj);
		 return obj;
	}
   
   @Transactional
	public void deleteCity(City obj) { 
	 	sessionFactory.getCurrentSession().delete(obj); 
	 	 	}
	 	 	
	 	 	

}
