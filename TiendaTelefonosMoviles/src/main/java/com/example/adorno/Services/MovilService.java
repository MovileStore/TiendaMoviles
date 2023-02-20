package com.example.adorno.Services;

import com.example.adorno.modelo.Movil;
import com.example.adorno.repositorios.MovilRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class MovilService {
    private static MovilRepository movilRepository;
    private List<Movil> moviles = getMoviles();
    private AtomicLong lastId = new AtomicLong();

    public MovilService(MovilRepository movilRepository) {
        MovilService.movilRepository = movilRepository;
    }

    public Optional<Movil> getMovilById(Long id) {
        return Optional.ofNullable(moviles.get(Math.toIntExact(id)));
    }

    public List<Movil> getMoviles() {
        return (List<Movil>) movilRepository.findAll();
    }

    public Optional<Movil> addMovil(Movil movil) {
        if (moviles.contains(movil)) {
            long id = lastId.incrementAndGet();
            movil.setId(id);
            moviles.add(movil);
            return Optional.of(movil);
        }
        return Optional.empty();
    }

    public Boolean contains(long id) {
        return moviles.stream().anyMatch(movil -> movil.getId() == id);
    }

}
