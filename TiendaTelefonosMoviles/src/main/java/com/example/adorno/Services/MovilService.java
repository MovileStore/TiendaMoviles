package com.example.adorno.Services;

import com.example.adorno.DTO.MovilDto;
import com.example.adorno.DTO.ProcesadorDto;
import com.example.adorno.filter.MovilFilter;
import com.example.adorno.modelo.Movil;
import com.example.adorno.modelo.movilesComparados;
import com.example.adorno.repositorios.MovilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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


    public Optional<Movil> addMovil(Movil movil) {
        if (!movilRepository.existsById(movil.getId())) {
            movilRepository.save(movil);
            return Optional.of(movil);
        }
        return Optional.empty();
    }

    public Optional<List<MovilDto>> getFiveMovil() {
        return Optional.of(StreamSupport.stream(movilRepository.findAll().spliterator(), false).map(movil -> new MovilDto(movil.getMarca(), movil.getNombre(), new ProcesadorDto(movil.getProcesador().getNumero_nucleos()), movil.getAlmacenamiento(), movil.getRam(), movil.getPrecio())).limit(5).toList());
    }

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

        return Optional.ofNullable(movilRepository.findByNfcIs(nfc));
    }

    public Optional<movilesComparados> getMovilesComparados(long idDispositivoA, long idDispositivoB) {
        movilesComparados movilesComparados = new movilesComparados(null, null);
        movilesComparados.setDispositivoA(movilRepository.findById(idDispositivoA));
        movilesComparados.setDispositivoB(movilRepository.findById(idDispositivoB));
        return Optional.of(movilesComparados);
    }

    public Optional<List<Movil>> getMovilesFilterBy(MovilFilter movilFilter) {
        return Optional.ofNullable(movilRepository.findByPrecioBetweenAndMarcaNombreAndRamBetweenAndNfcIs(movilFilter.getPrecio().getMin(), movilFilter.getPrecio().getMax(), movilFilter.getMarca(), movilFilter.getRam().getMin(), movilFilter.getRam().getMax(), movilFilter.isNfc()));
    }

    public Optional<List<Movil>> getMovileFilter(MovilFilter movilFilter) {


        List<Movil> listaFiltrada = new ArrayList<>();
        if (movilFilter.getPrecio() == null) {
            return Optional.of(listaFiltrada);
        } else {
            listaFiltrada = movilRepository.findByPrecioGreaterThanAndPrecioLessThan(movilFilter.getPrecio().getMin(), movilFilter.getPrecio().getMax());
        }

        if (movilFilter.getMarca().isEmpty()) {
            return Optional.of(listaFiltrada);
        } else {
            listaFiltrada = listaFiltrada.stream().filter(marca -> marca.getMarca().getNombre().equals(movilFilter.getMarca())).collect(Collectors.toList());
        }

        if (movilFilter.getRam() == null) {
            return Optional.of(listaFiltrada);
        } else {
            listaFiltrada = listaFiltrada.stream().filter(ram -> ram.getRam() <= movilFilter.getRam().getMin() && ram.getRam() >= movilFilter.getRam().getMax()).collect(Collectors.toList());
        }

        if (!movilFilter.isNfc()) {
            return Optional.of(listaFiltrada);
        } else {
            listaFiltrada = listaFiltrada.stream().filter(Movil::isNfc).collect(Collectors.toList());
        }

        return Optional.of(listaFiltrada);
    }
}
