package bvn.car;

import bvn.car.lib.Injector;
import bvn.car.model.Car;
import bvn.car.model.Door;
import bvn.car.model.Tire;
import bvn.car.model.Wheel;
import bvn.car.service.CarService;
import bvn.car.service.DoorService;
import bvn.car.service.PassengerService;
import bvn.car.service.TireService;
import bvn.car.service.WheelService;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Injector injector = Injector.getInstance("bvn.car");
    private static final CarService carService
            = (CarService) injector.getInstance(CarService.class);
    private static final TireService tireService
            = (TireService) injector.getInstance(TireService.class);
    private static final WheelService wheelService
            = (WheelService) injector.getInstance(WheelService.class);
    private static final DoorService doorService
            = (DoorService) injector.getInstance(DoorService.class);
    private static final PassengerService passengerService
            = (PassengerService) injector.getInstance(PassengerService.class);

    public static void main(String[] args) {

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
        System.out.println(zhiguli);
    }
}
