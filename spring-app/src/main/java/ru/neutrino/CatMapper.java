package ru.neutrino;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CatMapper implements RowMapper<Cat> {

	@Override
	public Cat mapRow(ResultSet catobj, int rowNum) throws SQLException {
		
		Cat cat = new Cat();
		cat.setId(catobj.getInt("id"));
		cat.setName(catobj.getString("name"));
		cat.setAge(catobj.getInt("age"));
		cat.setColor(catobj.getString("color"));	

		return cat;
	}

	
}
