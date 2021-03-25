package ru.neutrino.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Res")
@Setter
@Getter
public class Res {

	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	
	@ManyToMany 
	@JoinTable (name = "Countres", joinColumns = @JoinColumn (name = "resid"), inverseJoinColumns = @JoinColumn(name = "countid"))
	private List<Country> country = new ArrayList<Country>();
}
