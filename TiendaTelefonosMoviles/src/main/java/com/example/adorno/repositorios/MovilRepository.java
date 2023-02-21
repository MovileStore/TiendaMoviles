package com.example.adorno.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.adorno.modelo.Movil;

@Repository
public interface MovilRepository extends CrudRepository<Movil, Long> {
	//CAMBIOS DE MARIO REVISAR
	List<Movil> findById(long id);
	List<Movil> findByMarca(String marca);
    List<Movil> findByPrecioGreaterThanAndLessThan(float min, float max);
    List<Movil> findByRamGreaterThanAndLessThan(float min, float max);
    List<Movil> findAllByNfcState();
}
