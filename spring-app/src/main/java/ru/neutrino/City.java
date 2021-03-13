package ru.neutrino;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component() 
@Getter
@Setter
public class City {

	
	private int id;
	private String country;
	private String city;
	
	@Override
	public String toString() {
		return "City [id=" + id + ", country=" + country + ", city=" + city + "]";
	}
	
	
	
}
