package com.shulpin.service;

import com.shulpin.model.Cargo;

import java.util.List;

public interface CargoService {

    void saveCargo(Cargo cargo);

    List<Cargo> findAllCargo();

    void deleteCargoById(Long id);

    Cargo findById(Long id);

    void updateCargo(Cargo cargo);

}
