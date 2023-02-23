package com.example.adorno;

import com.example.adorno.DTO.MovilDto;
import com.example.adorno.ObjectMother.GeneradorMarcas;
import com.example.adorno.ObjectMother.GeneradorPantalla;
import com.example.adorno.ObjectMother.GeneradorProcesador;
import com.example.adorno.ObjectMother.GeneradorTelefonosMoviles;
import com.example.adorno.adornomappers.MovilMapper;
import com.example.adorno.modelo.Marca;
import com.example.adorno.modelo.Movil;
import com.example.adorno.modelo.Pantalla;
import com.example.adorno.modelo.Procesador;
import com.example.adorno.repositorios.MarcaRepository;
import com.example.adorno.repositorios.MovilRepository;
import com.example.adorno.repositorios.PantallaRepository;
import com.example.adorno.repositorios.ProcesadorRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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

    GeneradorMarcas gm;
    GeneradorProcesador gpro;
    GeneradorPantalla gp;
    GeneradorTelefonosMoviles gt = new GeneradorTelefonosMoviles();

    WebClient webClient;

    @BeforeEach
    public void before() {
        webClient = WebClient.create("http://localhost:8080");

    }

    @Test
    void contextLoads() {
        ResponseEntity<List> listaMovilesResponseEntity = webClient.get().uri("/movile/getMoviles").retrieve().toEntity(List.class).block();
        assert listaMovilesResponseEntity != null;
        List movilBody = listaMovilesResponseEntity.getBody();

        assert movilBody != null;
        List<MovilDto> movilesMapped = movilBody.stream().map((hashmap) -> new MovilMapper().map((LinkedHashMap) hashmap)).toList();

        ArrayList<MovilDto> listaMovilDto = new ArrayList<MovilDto>(movilesMapped);
        Assertions.assertEquals(listaMovilDto.size(), 1);

        //Carga de la base de datos
        List<Marca> marcas = GeneradorMarcas.generarMarca();
        List<Pantalla> pantallas = GeneradorPantalla.generarPantalla();
        List<Procesador> procesadores = GeneradorProcesador.generarProcesador();
        List<Movil> moviles = GeneradorTelefonosMoviles.generarMoviles();

        for (int i = 0; i < marcas.size(); i++) {
            Marca marca = marcas.get(i);
            marcaRepository.save(marca);
        }

        for (int i = 0; i < pantallas.size(); i++) {
            Pantalla pantalla = pantallas.get(i);
            pantallaRepository.save(pantalla);
        }

        for (int i = 0; i < procesadores.size(); i++) {
            Procesador procesador = procesadores.get(i);
            procesadorRepository.save(procesador);
        }

        for (int i = 0; i < moviles.size(); i++) {
            Movil m = moviles.get(i);
            movilRepository.save(m);
        }
    }

}
