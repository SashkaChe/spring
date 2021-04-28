package ru.neutrino;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.neutrino.model.Junior;
import ru.neutrino.service.Conversion;

public class Test {

	public static void main(String[] args) throws SQLException {

		ApplicationContext javaContext = new AnnotationConfigApplicationContext(EntityConfig.class);
		Conversion convertobj = (Conversion) javaContext.getBean(Conversion.class);

		List<String> listString = Arrays.asList("a", "b", "c", "c", "d");
		convertobj.convListToSet(listString).forEach(System.out::println);

		Junior obj = new Junior("Sashka", "Neutrino");

		System.out.println(convertobj.convJuniorToSenior(obj).toString());

	}
}
