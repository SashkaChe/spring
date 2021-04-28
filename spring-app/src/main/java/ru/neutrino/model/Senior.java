package ru.neutrino.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Senior {

	private String name;
	private String company;

	@Override
	public String toString() {
		return "Senior [name=" + name + ", company=" + company + "]";
	}

}
