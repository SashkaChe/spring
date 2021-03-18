package ru.neutrino.aop;

import lombok.Getter;
import lombok.Setter;
import ru.neutrino.model.Country;


@Setter
public class CityJPA {

	
	private int id;
	private String city;
	private Country country;
	
	
}
