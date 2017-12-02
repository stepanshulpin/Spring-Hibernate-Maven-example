package com.shulpin.dao;



import com.shulpin.model.Cargo;

import java.util.List;

public interface CargoDao {

    void saveCargo(Cargo cargo);

    List<Cargo> findAllCargo();

    void deleteCargoByName(String name);

    Cargo findByName(String name);

    void updateCargo(Cargo cargo);

}
