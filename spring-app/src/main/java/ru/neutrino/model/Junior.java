package ru.neutrino.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Junior {

	@NotNull(message = "ИМЯ NULL")
	private String name;
	@NotNull(message = "КОМПАНИЯ NULL")
	private String company;

	private int age;

	public Junior() {

	}

	public Junior(String name, String company, int age) {

		this.name = name;
		this.company = company;
		this.age = age;

	}

	@AssertTrue(message = "Не корректный возраст")
	public boolean isAge() {

		boolean result = true;
		if (age < 20) {
			result = false;
		}
		return result;

	}

}
