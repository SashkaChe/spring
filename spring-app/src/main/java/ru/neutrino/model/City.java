package ru.neutrino.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="City")
@Setter
@Getter
public class City implements Serializable {

	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="city")
	private String city;
	
	
	@ManyToOne 
	@JoinColumn(name = "country")
	private Country country;


	@Override
	public String toString() {
		
		return "City [id=" + id + ", city=" + city + " country=" + getCountry().getCountry()+ "]";
	}
	
	
	
}
