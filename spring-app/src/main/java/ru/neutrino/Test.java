package ru.neutrino;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.ConversionService;

import ru.neutrino.service.ServicePlanet;

public class Test {

	public static void main(String[] args) throws SQLException {

		ApplicationContext javaContext = new AnnotationConfigApplicationContext(EntityConfig.class);
		ServicePlanet servplanet = (ServicePlanet) javaContext.getBean(ServicePlanet.class);
		ConversionService conversionService = javaContext.getBean(ConversionService.class);

		List<String> listString = new ArrayList<>();
		listString.add("a");
		listString.add("b");
		listString.add("c");
		listString.add("c");

		Set<String> setString = conversionService.convert(listString, HashSet.class);

		for (String string : setString)
			System.out.println("Set: " + string);

		// servplanet.showallPlanet();

	}
}
