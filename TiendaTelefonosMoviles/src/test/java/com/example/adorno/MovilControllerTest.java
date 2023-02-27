package com.example.adorno;

import com.example.adorno.DTO.MovilDto;
import com.example.adorno.adornomappers.MovilMapper;
import com.example.adorno.repositorios.MovilRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * MovilController Tester.
 *
 * @author <Jesus_Macarro>
 * @version 1.0
 * @since <pre>feb 21, 2023</pre>
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MovilControllerTest {

    @Autowired
    MovilRepository movilRepository;
    WebClient webClient;

    @BeforeEach
    public void before() {
        webClient = WebClient.create("http://localhost:8080");

    }



    /**
     * Method: getMoviles()
     */


    @Test
    public void testGetMoviles() {

        ResponseEntity<List> listaMovilesResponseEntity = webClient.get().uri("/movile/getMoviles").retrieve().toEntity(List.class).block();
        assert listaMovilesResponseEntity != null;
        List movilBody = listaMovilesResponseEntity.getBody();

        List movilesMapped = movilBody.stream().map((hashmap) -> new MovilMapper().map((LinkedHashMap) hashmap)).toList();

        ArrayList<MovilDto> listaMovilDto = new ArrayList<MovilDto>(movilesMapped);
        assertEquals(listaMovilDto.size(), 1);


    }

    /**
     * Method: getMovilById(@RequestParam Long id)
     */
    @Test
    public void testGetMovilById() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addMovil(@RequestBody Movil movil)
     */
    @Test
    public void testAddMovil() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: updateMovil(@PathVariable Long id, @RequestBody UpdateMovilRequest movilUpdate)
     */
    @Test
    public void testUpdateMovil() throws Exception {
//TODO: Test goes here... 
    }


} 
