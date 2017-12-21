package com.shulpin.controller;

import com.shulpin.model.Cargo;
import com.shulpin.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CargoController {

    @Autowired
    CargoService cargoService;

    @GetMapping("/cargo/{id}")
    @Transactional
    public ResponseEntity getCargo(@PathVariable("id") Long id) {

        Cargo cargo = cargoService.findById(id);
        if (cargo == null) {
            return new ResponseEntity("No Cargo found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(cargo, HttpStatus.OK);
    }

    @GetMapping("/cargo")
    @Transactional
    public ResponseEntity<List<Cargo>> getAllCargo(){

        return new ResponseEntity<List<Cargo>>(cargoService.findAllCargo(), HttpStatus.OK);

    }

    @PostMapping("/addCargo")
    @Transactional
    public ResponseEntity addCargo(@RequestBody Cargo cargo){
        cargoService.saveCargo(cargo);
        return new ResponseEntity(cargo, HttpStatus.CREATED);
    }

    @DeleteMapping("/cargo/{id}")
    @Transactional
    public ResponseEntity deleteCargo(@PathVariable("id") Long id){

        cargoService.deleteCargoById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
