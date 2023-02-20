package com.example.adorno.repositorios;

import com.example.adorno.modelo.Pantalla;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PantallaRepository extends CrudRepository<Pantalla, Long> {
}
