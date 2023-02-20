package com.example.adorno.repositorios;

import com.example.adorno.modelo.Movil;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovilRepository extends CrudRepository<Movil, Long> {
    ObservationFilter addMovil(Movil movil);
}
