package ru.neutrino.aop;

import java.sql.Connection;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component() 
@Getter
@Setter
public class Cat {
	
	
	private int id;
	private String name;
	private int age;
	private String color;
	
	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", age=" + age + ", color=" + color + "]";
	}

	
	
	
}
