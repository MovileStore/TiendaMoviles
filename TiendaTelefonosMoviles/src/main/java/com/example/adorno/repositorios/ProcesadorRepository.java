package com.example.adorno.repositorios;

import com.example.adorno.modelo.Procesador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcesadorRepository extends CrudRepository<Procesador, Long> {
}
