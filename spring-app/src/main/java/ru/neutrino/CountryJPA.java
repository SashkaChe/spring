package ru.neutrino;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="Country")
@Getter
public class CountryJPA {

	@Id
    @Column
    @GeneratedValue
	private int id;
	
	@Column
	private String country;
	
}
