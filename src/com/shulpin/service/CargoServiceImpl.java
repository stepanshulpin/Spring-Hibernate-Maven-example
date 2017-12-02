package com.shulpin.service;

import com.shulpin.dao.CargoDao;
import com.shulpin.dao.CargoDaoImpl;
import com.shulpin.model.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("cargoService")
@Transactional
public class CargoServiceImpl implements CargoService {


    @Autowired
    private CargoDaoImpl dao;

    public void saveCargo(Cargo cargo) {

        dao.saveCargo(cargo);
    }

    public List<Cargo> findAllCargo() {
        return dao.findAllCargo();
    }

    public void deleteCargoByName(String name) {
        dao.deleteCargoByName(name);
    }

    public Cargo findByName(String name) {
        return dao.findByName(name);
    }

    public void updateCargo(Cargo cargo) {
        dao.updateCargo(cargo);
    }
}
