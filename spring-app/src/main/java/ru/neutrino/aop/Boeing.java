package ru.neutrino.aop;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Boeing") 
public class Boeing implements Airplane  {

	
	@Value("Blue")
	public String text;
	
	
	public String AirName() {
		return "Boeing";
	}
	
	public int AirSpeed() {
		return 800;
	}
	
	
	public void textBefore() {
		System.out.println("Текст до метода");
	}
	
	@Override
	public String toString() {
		return AirName() + " " + AirSpeed();
	}
	
}
