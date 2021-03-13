package ru.neutrino;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.orm.hibernate5.*;



import lombok.Getter;
import lombok.Setter;

@Component
@PropertySource("classpath:/datasource.properties")
@Getter
@Setter
public class CatDAO {
	
		
	@Autowired 
	private JdbcTemplate jdbc;
	
	@Autowired
	private Connection connection;	
	
	@Autowired 
	private NamedParameterJdbcTemplate namedParameterJdЬcTemplate;
	
	@Value("${data.username}")
	private String username;
	
	@Value("${data.password}")
	private String password;
	
	@Value("${data.url}")
	private String URL;
	
	
		
	

	
	
	
	
	public List<Country> myCountry() throws SQLException {

		return jdbc.query("select * from Country", new CountryMapper());
}
	
	
	
	public List<City> myCity() throws SQLException {

		return jdbc.query("SELECT City.id, City.city, Country.country FROM City, Country where City.country = Country.id", new CityMapper());

}



	
	public List<Cat> myCat() throws SQLException {

			return jdbc.query("select * from Cat", new CatMapper());
	}
	
	
	public void save(Cat cat) throws SQLException {
		jdbc.update("insert into Cat values(?, ?, ?, ?)", 4, "Малыш", 4, "Коричневый");
		
	}
	
	public String show(int id) throws SQLException {
		return jdbc.query("select * from Cat where id=?", new Object[] {id}, new CatMapper()).stream().findAny().orElse(null).toString();
	}
	
		
	
	
	
	public void update2(Integer id, String name, Integer age, String color) throws SQLException {
		
		Map<String, Object> obj = new HashMap<>();
		
		obj.put("id", id);
		obj.put("name1", name);
		obj.put("age", age);
		obj.put("color", color);
				
		
		namedParameterJdЬcTemplate.update("update Cat set name= :name1, age= :age, color= :color where id= :id", obj);		
	}
	
	
	public void update(int id) throws SQLException {
		jdbc.update("update Cat set name=?, age=?, color=? where id=?", "Малыш", 4, "Черепаховый", id);		
	}
	
	
	public void delete(int id) throws SQLException {
		jdbc.update("delete from Cat where id=?", new Object[] {id});
	}
	
	
}

