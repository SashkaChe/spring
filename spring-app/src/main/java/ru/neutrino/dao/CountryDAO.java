package ru.neutrino.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ru.neutrino.model.*;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;



@Transactional
@Repository 
public class CountryDAO {

	
	@Resource
	private SessionFactory sessionFactory;

	
   @Transactional(readOnly=true)
	public List<Country> showAll() throws SQLException {
		return sessionFactory.getCurrentSession().createQuery("select distinct c from Country c left join fetch c.res").list();
		
	}
	
   
 
   @Transactional(readOnly=true)
  	public Country showId(long id) throws SQLException {
  		return (Country) sessionFactory.getCurrentSession().createQuery("select c from Country c left join fetch c.res where c.id = :id").setParameter("id", id).uniqueResult();
  		
  	}
   
   
   @Transactional(readOnly=true)
 	public City showCity(int id) throws SQLException {
 		return (City) sessionFactory.getCurrentSession().createQuery("select c from City c where c.id = :id").setParameter("id", id).uniqueResult();
 		
 	}
   
   
   
 	public Country save(Country obj) throws SQLException {
 		 sessionFactory.getCurrentSession().saveOrUpdate(obj);
 		 return obj;
 	}
  
 	public void delete(Country obj) { 
 	sessionFactory.getCurrentSession().delete(obj); 
 	 	}
 	
 	
 
	
 	
 	
 	public void delete2(City obj) { 
 	 	sessionFactory.getCurrentSession().delete(obj); 
 	 	 	}
 	
   
 	
   @Transactional(readOnly=true)
	public List<City> showCity() throws SQLException {
		return sessionFactory.getCurrentSession().createQuery("select c from City c join fetch c.country t").list();
}

		
}
