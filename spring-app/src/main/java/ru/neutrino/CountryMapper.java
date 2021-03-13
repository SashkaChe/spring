package ru.neutrino;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CountryMapper implements RowMapper<Country> {

	@Override
	public Country mapRow(ResultSet catobj, int rowNum) throws SQLException {
		
		Country cat = new Country();
		cat.setId(catobj.getInt("id"));
		cat.setCountry(catobj.getString("country"));
		

		return cat;
	}

	
}

