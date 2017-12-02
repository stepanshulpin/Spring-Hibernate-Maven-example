package com.shulpin.Main;

import com.shulpin.model.Cargo;
import com.shulpin.service.CargoService;
import com.shulpin.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.sql.Date;
import java.util.List;

public class main {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CargoService service = (CargoService)context.getBean("cargoService");

        Cargo cargo1 = new Cargo();
        cargo1.setProductName("Potato");
        cargo1.setWeight(2.0);
        cargo1.setDestinationCity("London");
        cargo1.setDateOfShipment(new Date(2018,10,2));


        Cargo cargo2 = new Cargo();
        cargo1.setProductName("Banana");
        cargo1.setWeight(4.0);
        cargo1.setDestinationCity("Moscow");
        cargo1.setDateOfShipment(new Date(2017,11,13));

        service.saveCargo(cargo1);
        service.saveCargo(cargo2);

        List<Cargo> cargoes = service.findAllCargo();
        for (Cargo cargo : cargoes) {
            System.out.println(cargo);
        }

        service.deleteCargoByName("Banana");

        Cargo cargo = service.findByName("Potato");
        cargo.setWeight(6.0);
        service.updateCargo(cargo);

        List<Cargo> cargoesList = service.findAllCargo();
        for (Cargo c : cargoes) {
            System.out.println(c);
        }

    }

}
