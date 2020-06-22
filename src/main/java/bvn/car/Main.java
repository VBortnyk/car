package bvn.car;

import bvn.car.model.Car;
import bvn.car.model.Door;
import bvn.car.model.Passenger;
import bvn.car.model.Tire;
import bvn.car.model.Wheel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Tire> tireStorage = new ArrayList<>();
        while (tireStorage.size() < 20) {
            tireStorage.add(new Tire(1, "GoodYear", 16));
        }

        List<Wheel> wheels = new ArrayList<>();
        while (wheels.size() < 4) {
            Wheel wheel = new Wheel((long)wheels.size() + 1, 16, tireStorage.remove(1));
            wheels.add(wheel);
        }

        List<Passenger> passengers = new ArrayList<>();
        int count = 4;
        while (count > 0) {
            passengers.add(new Passenger("Passenger" + count, count + 20));
            count--;
        }

        Door door1 = new Door(1, Door.DoorMarker.FRONT_RIGHT, "Audi");
        Door door2 = new Door(2, Door.DoorMarker.FRONT_LEFT, "Audi");
        Door door3 = new Door(3, Door.DoorMarker.BACK_RIGHT, "Audi");
        Door door4 = new Door(4, Door.DoorMarker.BACK_LEFT, "Audi");
        Door[] doors = {door1, door2, door3, door4};

        Car car = new Car.CarBuilder()
                .setBrand("Audi")
                .setModel("A6")
                .setManufactureDate(LocalDate.of(2020, 01, 01))
                .setEngineType("Diesel")
                .setMaxSpeed(280)
                .setAccelerationTime(5.1)
                .setCapacity(5)
                .setPassengers(passengers)
                .setPassengersPresent()
                .setWheels(wheels)
                .setDoors(doors)
                .build();

        System.out.println(car.toString());

        car.addPassenger(new Passenger("Passenger", 20));
        System.out.println(car.getPassengersPresent());
    }
}
