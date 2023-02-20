package com.example.adorno.repositorios;

import com.example.adorno.modelo.Marca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MarcaRepository extends CrudRepository<Marca, Long> {
}
