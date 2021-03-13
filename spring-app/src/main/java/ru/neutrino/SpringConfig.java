package ru.neutrino;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.*;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;


@Configuration
@PropertySource("classpath:/datasource.properties")
public class SpringConfig {

	@Value("${data.url}")
	private String url;
	
	@Bean
	public DataSource dataSource() {
		
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername("postgres");
		dataSource.setPassword("admin");
		
		
		return dataSource;
		    }

	
	@Bean
	public SessionFactory sessionFac() {

		LocalSessionFactoryBean obj = new LocalSessionFactoryBean();
     	obj.setDataSource(dataSource());
        obj.setHibernateProperties(hibernateProperties());
     	 
		return obj.getObject();
		    }
	
	
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		LocalSessionFactoryBean obj = new LocalSessionFactoryBean();
     	obj.setDataSource(dataSource());
        obj.setHibernateProperties(hibernateProperties());
     	 
		return obj;
		    }
	
	
	 private final Properties hibernateProperties() {
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");

	        return hibernateProperties;
	    }


	
	@Bean
	public Connection connect() {
		
		 Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testsql", "postgres", "admin");
	
return connection;

		} catch (SQLException e) {
			e.printStackTrace();		
	}
		 
		 return connection;
	}
	
	
	
	
	
	
	
	
	
	
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		
		return new JdbcTemplate(dataSource());
	}
	
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdЬcTemplate() {
			return new NamedParameterJdbcTemplate(dataSource()); 
	}
	
	
		}






	

