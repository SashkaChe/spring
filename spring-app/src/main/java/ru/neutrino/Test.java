package ru.neutrino;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.neutrino.model.Junior;
import ru.neutrino.service.Conversion;

public class Test {

	public static void main(String[] args) throws SQLException, ParseException, Exception {

		AnnotationConfigApplicationContext javaContext = new AnnotationConfigApplicationContext(EntityConfig.class);
		Conversion convertobj = (Conversion) javaContext.getBean(Conversion.class);

		List<String> listString = Arrays.asList("a", "b", "c", "c", "d");
		convertobj.convListToSet(listString).forEach(System.out::println);

		Junior obj = new Junior("Sashka", "Neutrino", 30);

		Junior obj2 = new Junior();

		// Интерфейс ConversionService (делаем из Джуниора Сеньора)
		System.out.println(convertobj.convJuniorToSenior(obj).toString());

		// Интерфейс Formatter (строку в число и число в строку)
		System.out.println(convertobj.convStringToInteger("1 3 4", Locale.ENGLISH));
		System.out.println(convertobj.convIntegerToString(5345, Locale.ENGLISH));

		// Валидация поля Возраст у объекта Джуниор
		System.out.println(convertobj.validateJunior(obj));

		// Асинхронное выполнение заданий

		convertobj.asyncTask();

		for (int i = 1; i < 10; i++) {
			System.out.println("------------------");
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
