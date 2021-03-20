package ru.neutrino.aop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class CityMapper implements ResultSetExtractor<List> {

	
	   public List<City1> extractData(ResultSet rs)  throws SQLException, DataAccessException {
	      
		   
		   List<City1> cityname = new ArrayList<>();
		   
		  while (rs.next()) {
	          
	        	City1 obj = new City1();
	        	
	        	
	        	obj.setId(rs.getInt("id"));
	        	obj.setCity(rs.getString("city"));
	        	obj.setCountry(rs.getString("country"));
	        	
	        	cityname.add(obj);
	        	
	    
	        }
	        return cityname;
	    }

	
}
