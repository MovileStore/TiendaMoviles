package com.example.adorno.Controller;

import com.example.adorno.DTO.MovilDto;
import com.example.adorno.Services.MovilService;
import com.example.adorno.UpdateMovil.UpdateMovilRequest;
import com.example.adorno.filter.MovilFilter;
import com.example.adorno.filter.Range;
import com.example.adorno.modelo.Movil;
import com.example.adorno.modelo.movilesComparados;
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
    @GetMapping("/getMovilById/{id}")
    public ResponseEntity<Movil> getMovilById(@PathVariable("id") Long id) {
        Optional<Movil> movil = movilService.getMovilById(id);
        return movil.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/addMovil")
    public ResponseEntity<Movil> addMovil(@RequestBody Movil movil) {
        return movilService.addMovil(movil).map((newMovil) -> new ResponseEntity<>(newMovil, HttpStatus.CREATED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE));
    }

    @PutMapping("/updateMovil/{id}")
    public ResponseEntity<UpdateMovilRequest> updateMovil(@PathVariable Long id, @RequestBody UpdateMovilRequest movilUpdate) {
        return null;
    }

    //CAMBIOS DE MARIO REVISAR
    @GetMapping("/get/getMovilesByMarca/{marca}")
    public ResponseEntity<List<Movil>> getMovilesByMarca(@PathVariable("marca") String marca) {
        if (movilService.getMovilesByMarca(marca).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movilService.getMovilesByMarca(marca).get(), HttpStatus.OK);
    }

    @GetMapping("/get/getMovilesByPrecio/{min}-{max}")
    public ResponseEntity<List<Movil>> getMovilesByPrecio(@PathVariable("min") float min, @PathVariable("max") float max) {
        if (movilService.getMovilesByPrecio(min, max).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movilService.getMovilesByPrecio(min, max).get(), HttpStatus.OK);
    }

    @GetMapping("/get/getMovilesByRam/{min}-{max}")
    public ResponseEntity<List<Movil>> getMovilesByRAM(@PathVariable("min") float min, @PathVariable("max") float max) {
        if (movilService.getMovilesByRAM(min, max).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movilService.getMovilesByRAM(min, max).get(), HttpStatus.OK);
    }

    @GetMapping("/get/getFiveMoviles")
    public ResponseEntity<List<MovilDto>> getFiveMoviles() {

        return new ResponseEntity<>(movilService.getFiveMovil().get(), HttpStatus.OK);
    }

    @GetMapping("/get/getMovilesFilter/")
    public ResponseEntity<List<Movil>> getMovilesByFilter(@RequestParam("Pmin") long Pmin, @RequestParam("Pmax") long Pmax, @RequestParam("Marca") String Marca, @RequestParam("RAMMin") long RAMMin, @RequestParam("RAMMax") long RAMMax, @RequestParam("nfc") Boolean nfc) {

        MovilFilter movilFilter = new MovilFilter((new Range<>(Pmin, Pmax)), Marca, new Range<>(RAMMin, RAMMax), nfc);
        if (movilService.getMovileFilter(movilFilter).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movilService.getMovilesFilterBy(movilFilter).get(), HttpStatus.OK);
    }

    @GetMapping("/get/movilesComparados/{idDispositivoA}-{idDispositivoB}")
    public ResponseEntity<movilesComparados<Movil>> getMovilesComparadosByIDs(@PathVariable("idDispositivoA") Long idDispositivoA, @PathVariable("idDispositivoB") Long idDispositivoB) {
        if (movilService.getMovilesComparados(idDispositivoA, idDispositivoB).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movilService.getMovilesComparados(idDispositivoA, idDispositivoB).get(), HttpStatus.OK);
    }

}
