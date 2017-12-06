package com.shulpin;

import com.shulpin.model.Cargo;
import com.shulpin.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CargoController {

    @Autowired
    CargoService cargoService;

    @GetMapping("/cargo/{id}")
    public ResponseEntity getCustomer(@PathVariable("id") Long id) {

        Cargo cargo = cargoService.findById(id);
        if (cargo == null) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(cargo, HttpStatus.OK);
    }
}
