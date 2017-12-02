package com.shulpin.service;

import com.shulpin.model.Cargo;

import java.util.List;

public interface CargoService {

    void saveCargo(Cargo cargo);

    List<Cargo> findAllCargo();

    void deleteCargoByName(String name);

    Cargo findByName(String name);

    void updateCargo(Cargo cargo);

}
