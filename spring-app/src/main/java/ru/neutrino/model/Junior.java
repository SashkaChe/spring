package ru.neutrino.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Junior {

	private String name;
	private String company;

	public Junior(String name, String company) {

		this.name = name;
		this.company = company;

	}

}
