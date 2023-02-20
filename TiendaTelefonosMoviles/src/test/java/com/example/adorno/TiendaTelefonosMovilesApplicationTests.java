package com.example.adorno;

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

@SpringBootTest
class TiendaTelefonosMovilesApplicationTests {

    @Autowired
    MovilRepository movilRepository;

    @Autowired
    PantallaRepository pantallaRepository;

    @Autowired
    MarcaRepository marcaRepository;

    @Autowired
    ProcesadorRepository procesadorRepository;

    @Test
    void contextLoads() {

        Pantalla pantalla1 = new Pantalla(1, "Amoled");
        Marca marca1 = new Marca(1, "Samsung");
        Procesador procesador1 = new Procesador(1, 4, "Snapdragon", 123);

        Movil m1 = new Movil(1, "s23", "20/20/20", 12, 500, 5000, 5, 6, 4, 1, 3, 24, true, 1300, marca1, pantalla1, procesador1);

        pantallaRepository.save(pantalla1);

        marcaRepository.save(marca1);

        procesadorRepository.save(procesador1);

        movilRepository.save(m1);

    }

}
