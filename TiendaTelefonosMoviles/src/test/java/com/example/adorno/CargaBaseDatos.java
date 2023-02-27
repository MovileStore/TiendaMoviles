package com.example.adorno;

import com.example.adorno.ObjectMother.GeneradorMarcas;
import com.example.adorno.ObjectMother.GeneradorPantalla;
import com.example.adorno.ObjectMother.GeneradorProcesador;
import com.example.adorno.ObjectMother.GeneradorTelefonosMoviles;
import com.example.adorno.modelo.Marca;
import com.example.adorno.modelo.Movil;
import com.example.adorno.modelo.Pantalla;
import com.example.adorno.modelo.Procesador;
import com.example.adorno.repositorios.MarcaRepository;
import com.example.adorno.repositorios.MovilRepository;
import com.example.adorno.repositorios.PantallaRepository;
import com.example.adorno.repositorios.ProcesadorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CargaBaseDatos {

    @Autowired
    MovilRepository movilRepository;

    @Autowired
    PantallaRepository pantallaRepository;

    @Autowired
    MarcaRepository marcaRepository;

    @Autowired
    ProcesadorRepository procesadorRepository;

    GeneradorMarcas gm;
    GeneradorProcesador gpro;
    GeneradorPantalla gp;
    GeneradorTelefonosMoviles gt = new GeneradorTelefonosMoviles();

    @Test
    void contextLoads() {
        List<Marca> marcas = GeneradorMarcas.generarMarca();
        List<Pantalla> pantallas = GeneradorPantalla.generarPantalla();
        List<Procesador> procesadores = GeneradorProcesador.generarProcesador();
        List<Movil> moviles = GeneradorTelefonosMoviles.generarMoviles();

        marcaRepository.saveAll(marcas);

        pantallaRepository.saveAll(pantallas);

        procesadorRepository.saveAll(procesadores);

        for (int i = 0; i < moviles.size(); i++) {
            Movil m = moviles.get(i);
            movilRepository.save(m);
        }
    }
}

