package ru.neutrino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Solution {

	
	public String test = "test";
	
	@Autowired 
	@Qualifier("Boeing") 
	private Airplane air;
	private int num;
	private String name = "Хеллоу, Бин!!";
	
	@Value("Валу для name2")
	private String name2;
	
	public void printText(int x, String y) {
		System.out.println("Текст");
	}
	
	
	public void printNumber() {
		System.out.println("Метод printNumber");
	}
	
	
	public int getInt(int x) {
		System.out.println("Результат метода");
		return x;
	}
	
	
	public Solution () {
	}
	
	@Autowired 
	public Solution (@Value("100") int num) {
		this.num = num;
	}
	
	

	
}
