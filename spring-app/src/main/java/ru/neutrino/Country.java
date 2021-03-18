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
@Getter
public class Country implements Serializable {

	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="country")
	private String country;
	
	@Override
	public String toString() {
	return "Country [id=" + id + ", country=" + country + "]";
	}	
	
	
	
}
