package ru.neutrino.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Country")
@Setter
@Getter
public class Country implements Serializable {

	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="country")
	private String country;
	
	@OneToMany(mappedBy = "country", cascade=CascadeType.ALL, orphanRemoval=true) 
	private List<City> city = new ArrayList<City>(); 
		
	
	@ManyToMany
	@JoinTable (name = "Countres", joinColumns = @JoinColumn (name = "countid"), inverseJoinColumns = @JoinColumn(name = "resid"))
	private List<Res> res = new ArrayList<Res>();


	@Override
	public String toString() {
		return "Country [id=" + id + ", country=" + country + "]";
	} 
	
	
	
	
	
	
}
