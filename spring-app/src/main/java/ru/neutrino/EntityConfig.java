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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@PropertySource("classpath:/datasource.properties")
@Import({ SpringConfig.class, DataConfig.class, ConversionConfig.class })
@ComponentScan(basePackages = "ru.neutrino")
@EnableJpaRepositories(basePackages = "ru.neutrino.dao")
@EnableScheduling
@EnableAsync
public class EntityConfig {

	@Resource
	private DataSource dataSource;

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory());
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	@Bean
	@Primary
	public EntityManagerFactory entityManagerFactory() {

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

	/*
	 * @Scheduled(fixedRate = 5000) public void reportCurrentTime() {
	 * System.out.println("Случайное число каждые 5 секунд " + Math.random() * 100);
	 * }
	 * 
	 */

}
