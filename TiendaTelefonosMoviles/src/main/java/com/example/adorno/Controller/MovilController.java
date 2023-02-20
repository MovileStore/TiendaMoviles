package com.example.adorno.Controller;

import com.example.adorno.Services.MovilService;
import com.example.adorno.UpdateMovil.UpdateMovilRequest;
import com.example.adorno.modelo.Movil;
import com.example.adorno.repositorios.MovilRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@Slf4j
@RequestMapping("/movile")
public class MovilController {

    private MovilService movilService;




    @GetMapping("/getMoviles")
    public List<Movil> getMoviles() {
        return movilService.getMoviles();
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @GetMapping("/getMovilById")
    public ResponseEntity<Movil> getMovilById(@RequestParam Long id) {
        Optional<Movil> movil = movilService.getMovilById(id);
        return movil.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/addMovil")
    public ResponseEntity<Movil> addMovil(@RequestBody Movil movil) {
        return movilService.addMovil(movil).map((newMovil) -> new ResponseEntity<Movil>(newMovil, HttpStatus.CREATED)).orElseGet(() -> new ResponseEntity<Movil>(HttpStatus.NOT_ACCEPTABLE));

    }

    @PutMapping("/updateMovil/{id}")
    public ResponseEntity<UpdateMovilRequest> updateMovil(@PathVariable Long id, @RequestBody UpdateMovilRequest movilUpdate) {
        return null;
    }

}
