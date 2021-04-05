package ru.neutrino.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ru.neutrino.model.Planet;


public interface PlanetRepo extends JpaRepository<Planet, Integer> {

}
