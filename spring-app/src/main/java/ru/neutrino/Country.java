package ru.neutrino;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component() 
@Getter
@Setter
public class Country {

	
	private int id;
	private String country;

	
	@Override
	public String toString() {
		return "Country [id=" + id + ", country=" + country + "]";
	}
}

