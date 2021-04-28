package ru.neutrino.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import ru.neutrino.model.Junior;
import ru.neutrino.model.Senior;

@Component
public class Conversion {

	@Autowired
	private ConversionService conversionService;

	public Set<String> convListToSet(List<String> obj) {
		return conversionService.convert(obj, HashSet.class);
	}

	public Senior convJuniorToSenior(Junior obj) {
		return conversionService.convert(obj, Senior.class);
	}

}