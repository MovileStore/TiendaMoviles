package com.example.adorno.Services;

import com.example.adorno.filter.MovilFilter;
import com.example.adorno.modelo.Movil;
import com.example.adorno.repositorios.MovilRepository;

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


    public Optional<Movil> addMovil( Movil movil) {
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

    public Optional<List<Movil>> getMovileFilter(MovilFilter movilFilter, String marcaBusqueda, Long ramBusqueda) {
        /*.filter((ram)->{movilFilter.getRam().isBetween(movil.getRam());}).filter((nfc)->{movilFilter.hasNfc().equals(movil.getNfc);});*/
        List<Movil> listaFiltradata;
        List<Movil> listaMovilesByPrecio = movilRepository.findByPrecioGreaterThanAndPrecioLessThan(movilFilter.getPrecio().getMin(), movilFilter.getPrecio().getMax());
        List<Movil> filterByMarca = listaMovilesByPrecio.stream().filter((marca) -> movilFilter.getMarca().equals(marcaBusqueda)).toList();
        //Hay un problema con este filtro por que el el .isBetween intenta accedera a la clase de Long y no existe ningun metodo asi en la clase
        List<Movil> filterByRAM = filterByMarca.stream().filter((ram) -> movilFilter.getRam().isBetween(ram)).toList();
        return null;
    }

}
