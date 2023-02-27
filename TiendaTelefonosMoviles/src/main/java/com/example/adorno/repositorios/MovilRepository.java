package com.example.adorno.repositorios;

import com.example.adorno.modelo.Movil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovilRepository extends CrudRepository<Movil, Long> {
    //CAMBIOS DE MARIO REVISAR

    List<Movil> findByMarcaNombre(String marca);

    List<Movil> findByPrecioGreaterThanAndPrecioLessThan(float min, float max);

    List<Movil> findByRamGreaterThanAndRamLessThan(float min, float max);

    List<Movil> findByNfcIs(boolean nfc);

    List<Movil> findByPrecioBetweenAndMarcaNombreAndRamBetweenAndNfcIs(float min, float max, String marca, float minRam, float maxRam, boolean nfc);

}
