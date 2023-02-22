package com.example.adorno.Services;

import com.example.adorno.filter.MovilFilter;
import com.example.adorno.modelo.Movil;
import com.example.adorno.repositorios.MovilRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovilService {
    @Autowired
    private MovilRepository movilRepository;


    public Optional<Movil> getMovilById(Long id) {
        return movilRepository.findById(id);
    }

    public List<Movil> getMoviles() {
        return (List<Movil>) movilRepository.findAll();
    }


    public Optional<Movil> addMovil(@NotNull Movil movil) {
        if (!movilRepository.existsById(movil.getId())) {
            movilRepository.save(movil);
            return Optional.of(movil);
        }
        return Optional.empty();
    }

    //CAMBIOS DE MARIO REVISAR
    public Optional<List<Movil>> getMovilesByMarca(String marca) {
        return Optional.ofNullable(movilRepository.findByMarcaNombre(marca));
    }

    public Optional<List<Movil>> getMovilesByPrecio(float min, float max) {

        return Optional.ofNullable(movilRepository.findByPrecioGreaterThanAndPrecioLessThan(min, max));
    }

    public Optional<List<Movil>> getMovilesByRAM(float min, float max) {

        return Optional.ofNullable(movilRepository.findByRamGreaterThanAndRamLessThan(min, max));
    }

    public Optional<List<Movil>> getMovilesWithNFC(Boolean nfc) {

        return Optional.ofNullable(movilRepository.findAllByNfcIs(nfc));
    }
    
    public Optional<List<Movil>> getMovileFilter(MovilFilter movilFilter){
    	movilRepository.findByPrecioGreaterThanAndPrecioLessThan(movilFilter.getPrecio().getMin(),movilFilter.getPrecio().getMax())
    			.filter((marca)->{movilFilter.getMarca().equals(movil.getMarca());})
    			.filter((ram)->{movilFilter.getRam().isBetween(movil.getRam());})
    			.filter((nfc)->{movilFilter.hasNfc().equals(movil.getNfc);});
    }

}
