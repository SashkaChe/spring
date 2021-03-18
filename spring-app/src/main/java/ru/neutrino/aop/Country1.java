package ru.neutrino.aop;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component() 
@Getter
@Setter
public class Country1 {

	
	private int id;
	private String country;

	
	@Override
	public String toString() {
		return "Country [id=" + id + ", country=" + country + "]";
	}
}

