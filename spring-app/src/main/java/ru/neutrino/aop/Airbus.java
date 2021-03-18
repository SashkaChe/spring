package ru.neutrino.aop;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("Airbus") 
@PropertySource("classpath:/datasource.properties")
public class Airbus implements Airplane  {


	
	public Solution obj;
	
	public Airbus (Solution obj) {
		this.obj = obj;
	}
	
    @Value("#{solution.getName}")
	private String text;
	
	public String getText() {
		return text;
	}
	
	public String AirName() {
		return "Airbus";
	}
	
	public int AirSpeed() {
		return 900;
	}

	@Override
	public String toString() {
		return AirName() + " " + AirSpeed() + " " + text;
	}
	
}
