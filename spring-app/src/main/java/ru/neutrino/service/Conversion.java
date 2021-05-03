package ru.neutrino.service;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import ru.neutrino.model.Junior;
import ru.neutrino.model.Senior;

@Component
public class Conversion {

	@Autowired
	private ConversionService conversionService;

	@Autowired
	private Validator validator;

	public Set<String> convListToSet(List<String> obj) {
		return conversionService.convert(obj, HashSet.class);
	}

	public Senior convJuniorToSenior(Junior obj) {
		return conversionService.convert(obj, Senior.class);
	}

	Formatter<Integer> format = new Formatter<Integer>() {

		@Override
		public Integer parse(String text, Locale locale) throws ParseException {
			return Integer.valueOf(text.replace(" ", ""));
		}

		@Override
		public String print(Integer integer, Locale locale) {
			return "Integer: " + integer;
		}

	};

	public Integer convStringToInteger(String obj, Locale locale) throws ParseException {
		return format.parse(obj, locale);
	}

	public String convIntegerToString(Integer obj, Locale locale) throws ParseException {
		return format.print(obj, locale);
	}

	public Set<ConstraintViolation<Junior>> validateJunior(Junior junior) {
		return validator.validate(junior);
	}

}