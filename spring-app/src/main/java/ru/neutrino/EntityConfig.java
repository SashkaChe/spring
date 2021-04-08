package ru.neutrino;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@Configuration
@PropertySource("classpath:/datasource.properties")
@Import({SpringConfig.class, DataConfig.class })
@ComponentScan(basePackages = "ru.neutrino")
public class EntityConfig {

	@Resource
	private DataSource dataSource;

	@Bean 
	@Primary
	public PlatformTransactionManager transactionManager() { 
	return new JpaTransactionManager((EntityManagerFactory) entityFactory());
	}

	
	
	@Bean 
	public JpaVendorAdapter jpaVendorAdapter() { 
	return new HibernateJpaVendorAdapter(); 
}
			
	
	@Bean
	@Primary
	public EntityManagerFactoryAccessor entityFactory() {
	
		
	//	Properties hibernateProperties = new Properties();
	 //   hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
	    
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean(); 
        factoryBean.setPackagesToScan("ru.neutrino"); 
        factoryBean.setDataSource(dataSource); 
    //    factoryBean.setJpaProperties(hibernateProperties); 
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter()); 
        factoryBean.afterPropertiesSet(); 
      
        return (EntityManagerFactoryAccessor) factoryBean.getNativeEntityManagerFactory(); 

		    }

	
}
