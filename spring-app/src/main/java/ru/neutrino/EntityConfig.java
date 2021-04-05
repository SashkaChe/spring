package ru.neutrino;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ru.neutrino.repo.PlanetRepo;
import ru.neutrino.service.ServicePlanet;

@EnableTransactionManagement
@Configuration
@PropertySource("classpath:/datasource.properties")
@Import({SpringConfig.class, DataConfig.class })
@ComponentScan(basePackages = "ru.neutrino")
@EnableJpaRepositories(basePackages = "ru.neutrino.repo") 
public class EntityConfig {

	@Resource
	private DataSource dataSource;

	@Bean 
	public PlatformTransactionManager transactionManager() { 
	return new JpaTransactionManager(entityFactory());
	}

	
	
	@Bean 
	public JpaVendorAdapter jpaVendorAdapter() { 
	return new HibernateJpaVendorAdapter(); 
}
			
	
	@Bean
	@Primary
	public EntityManagerFactory entityFactory() {
	
		
		Properties hibernateProperties = new Properties();
	    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
	    
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean(); 
        factoryBean.setPackagesToScan("ru.neutrino"); 
        factoryBean.setDataSource(dataSource); 
        factoryBean.setJpaProperties(hibernateProperties); 
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter()); 
        factoryBean.afterPropertiesSet(); 
      
        return factoryBean.getNativeEntityManagerFactory(); 

		    }

	
}
