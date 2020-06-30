package bvn.car.controllers;

import bvn.car.mapper.CarMapper;
import bvn.car.model.Car;
import bvn.car.model.Door;
import bvn.car.model.Tire;
import bvn.car.model.Wheel;
import bvn.car.service.CarService;
import bvn.car.service.DoorService;
import bvn.car.service.TireService;
import bvn.car.service.WheelService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InjectDataController {

    private final CarService carService;
    private final TireService tireService;
    private final WheelService wheelService;
    private final DoorService doorService;
    private final CarMapper carMapper;

    public InjectDataController(CarService carService,
                                TireService tireService,
                                WheelService wheelService,
                                DoorService doorService,
                                CarMapper carMapper) {
        this.carService = carService;
        this.tireService = tireService;
        this.wheelService = wheelService;
        this.doorService = doorService;
        this.carMapper = carMapper;
    }

    @PostConstruct
    public void init() {
        injectData();
    }

    @GetMapping("/inject")
    public void injectData() {
        List<Wheel> wheels = new ArrayList<>();
        while (wheels.size() < 4) {
            Tire tire = new Tire(1, "GoodYear", 18);
            tireService.create(tire);
            Wheel wheel = new Wheel(18, tire);
            wheelService.create(wheel);
            wheels.add(wheel);
        }

        List<Door> doors = new ArrayList<>();
        doors.add(doorService.create(new Door("Zhiguli")));
        doors.add(doorService.create(new Door("Zhiguli")));

        Car.CarBuilder carBuilder = new Car.CarBuilder();
        Car zhiguli = carBuilder.setBrand("Zhiguli")
                .setWheels(wheels)
                .setDoors(doors)
                .setEngineType("Gasoline")
                .build();
        carService.create(zhiguli);
        System.out.println("Initial data injected");
    }
}
