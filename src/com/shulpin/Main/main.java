package com.shulpin.Main;

import com.shulpin.model.Cargo;
import com.shulpin.service.CargoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.List;

public class main {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring-config.xml");

        CargoService service = (CargoService)context.getBean("cargoService");

        Cargo cargo1 = new Cargo();
        cargo1.setProductName("Potato");
        cargo1.setWeight(2.0);
        cargo1.setDestinationCity("London");
        cargo1.setDateOfShipment(new Date(115,10,2));


        Cargo cargo2 = new Cargo();
        cargo2.setProductName("Banana");
        cargo2.setWeight(4.0);
        cargo2.setDestinationCity("Moscow");
        cargo2.setDateOfShipment(new Date(117,11,13));

        service.saveCargo(cargo1);
        service.saveCargo(cargo2);

        List<Cargo> cargoes = service.findAllCargo();
        for (Cargo cargo : cargoes) {
            System.out.println(cargo);
        }

        service.deleteCargoById((long) 1);

        Cargo cargo = service.findById((long) 2);
        cargo.setWeight(6.0);
        service.updateCargo(cargo);

        List<Cargo> cargoesList = service.findAllCargo();
        for (Cargo c : cargoesList) {
            System.out.println(c);
        }

    }

}
