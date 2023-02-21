package com.example.adorno.Services;

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


}
