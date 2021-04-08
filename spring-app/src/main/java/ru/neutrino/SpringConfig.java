package ru.neutrino;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.*;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@PropertySource("classpath:/datasource.properties")
public class SpringConfig {


	
	@Resource
	private DataSource dataSource;
	
		

	@Bean 
	public PlatformTransactionManager transactionManager() throws IOException {
	return new HibernateTransactionManager(sessionFac()); 
	}

	
	
	@Bean
	public SessionFactory sessionFac() throws IOException {
		
		Properties hibernateProperties = new Properties();
	    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
	   				
		LocalSessionFactoryBean obj = new LocalSessionFactoryBean();
     	obj.setDataSource(dataSource);
     	obj.setPackagesToScan("ru.neutrino"); 
        obj.setHibernateProperties(hibernateProperties);
        obj.afterPropertiesSet();
        		
		return obj.getObject();
		    }
	
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
	return new JdbcTemplate(dataSource);
		}	
		

	
}
	

	





	

