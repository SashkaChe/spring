package ru.neutrino;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;



@Transactional
@Repository 
public class CountryDAO {

	
	@Resource
	private SessionFactory sessionFactory;

	

	public List<CountryJPA> showAll() throws SQLException {
		return sessionFactory.getCurrentSession().createQuery("FROM Country", CountryJPA.class).list();
}
	
		
}
