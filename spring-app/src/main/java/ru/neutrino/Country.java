package ru.neutrino;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.Getter;
import lombok.Setter;

@EnableTransactionManagement
@Entity
@Table(name="Country")
@Setter
public class CountryJPA implements Serializable {

	
	private long id;
	private String country;
	
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId () { 
		return id; 
	}	
	
	
	@Column(name="country")
	public String getCountry () { 
		return country; 
	}


	@Override
	public String toString() {
		return "CountryJPA [id=" + id + ", country=" + country + "]";
	}	
	
	
	
}
