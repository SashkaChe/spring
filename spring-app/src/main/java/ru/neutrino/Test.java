package ru.neutrino;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.neutrino.service.ServicePlanet;

public class Test {

	public static void main(String[] args) throws SQLException {

		ApplicationContext javaContext = new AnnotationConfigApplicationContext(EntityConfig.class);
		ServicePlanet servplanet = (ServicePlanet) javaContext.getBean(ServicePlanet.class);

		List<String> listString = Arrays.asList("a", "b", "c", "c", "d");
		servplanet.convListToSet(listString).forEach(System.out::println);

	}
}
