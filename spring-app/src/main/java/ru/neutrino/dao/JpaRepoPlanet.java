package ru.neutrino.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.neutrino.model.Planet;

@Repository
public interface JpaRepoPlanet extends JpaRepository<Planet, Integer>  {

}
