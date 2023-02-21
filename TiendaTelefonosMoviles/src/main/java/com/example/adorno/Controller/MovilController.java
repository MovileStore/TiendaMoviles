package com.example.adorno.Controller;

import com.example.adorno.Services.MovilService;
import com.example.adorno.UpdateMovil.UpdateMovilRequest;
import com.example.adorno.modelo.Movil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@Slf4j
@RequestMapping("/movile")
public class MovilController {
    @Autowired
    private MovilService movilService;


    @GetMapping("/getMoviles")
    public ResponseEntity<List<Movil>> getMoviles() {
        List<Movil> moviles = movilService.getMoviles();
        return new ResponseEntity<>(moviles, HttpStatus.OK);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @GetMapping("/getMovilById")
    public ResponseEntity<Movil> getMovilById(@RequestParam Long id) {
        Optional<Movil> movil = movilService.getMovilById(id);
        return movil.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/addMovil")
    public ResponseEntity<Movil> addMovil(@RequestBody Movil movil) {
        Movil newMovil = movilService.crearMovil(movil);
        return new ResponseEntity<>(newMovil, HttpStatus.CREATED);

//        return movilService.addMovil(movil).map((newMovil) ->
//                        new ResponseEntity<>(newMovil, HttpStatus.CREATED))
//                .orElseGet(() ->
//                        new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE));
    }

    @PutMapping("/updateMovil/{id}")
    public ResponseEntity<UpdateMovilRequest> updateMovil(@PathVariable Long id, @RequestBody UpdateMovilRequest movilUpdate) {
        return null;
    }

}
