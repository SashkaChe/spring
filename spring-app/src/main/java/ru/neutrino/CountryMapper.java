package ru.neutrino;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CountryMapper implements RowMapper<Country1> {

	@Override
	public Country1 mapRow(ResultSet catobj, int rowNum) throws SQLException {
		
		Country1 cat = new Country1();
		cat.setId(catobj.getInt("id"));
		cat.setCountry(catobj.getString("country"));
		

		return cat;
	}

	
}

