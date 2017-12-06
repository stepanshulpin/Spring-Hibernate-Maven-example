package com.shulpin.dao;



import com.shulpin.model.Cargo;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;


public interface CargoDao {

    void saveCargo(Cargo cargo);

    List<Cargo> findAllCargo();

    void deleteCargoById(Long id);

    Cargo findById(Long id);

    void updateCargo(Cargo cargo);

}
