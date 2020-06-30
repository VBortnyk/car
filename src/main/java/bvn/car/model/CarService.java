package bvn.car.model;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    public boolean addPassenger(Car car, Passenger passenger) {
        if (car.getPassengersPresent() == car.getCapacity()) {
            return false;
        }
        car.getPassengers().add(passenger);
        return true;
    }

    public boolean dropOffPassenger(Car car, Passenger passenger) {
        return car.getPassengers().removeIf(passenger::equals);
    }

    public List<Passenger> clearPassengers(Car car) {
        List<Passenger> removedPassengers = new ArrayList<>(car.getPassengers());
        car.getPassengers().clear();
        return removedPassengers;
    }

    public Wheel getWheelByIndex(Car car, Long index) {
        try {
            return car.getWheels().stream().filter(w -> w.getId().equals(index)).findFirst().get();
        } catch (NullPointerException e) {
            System.out.println("No wheel with id: " + index + "found");
        }
        return null;
    }

    public List<Wheel> dismantleAllWheels(Car car) {
        List<Wheel> dismantledWheels = new ArrayList<>(car.getWheels());
        car.getWheels().clear();
        return dismantledWheels;
    }

    public void addWheels(Car car, int quantity) {
        while (quantity > 0) {
            Tire tire = new Tire(1, "someProducer", 16);
            Wheel wheel = new Wheel(16, tire);
            car.getWheels().add(wheel);
            quantity--;
        }
    }

    public int changeCurrentSpeed(Car car, int changeValue) {
        if (car.getCurrentSpeed() + changeValue >= car.getMaxSpeed()) {
            car.setCurrentSpeed(car.getMaxSpeed());
            return car.getCurrentSpeed();
        }
        if (car.getCurrentSpeed() + changeValue < 0) {
            car.setCurrentSpeed(0);
            return 0;
        }
        return car.getCurrentSpeed() + changeValue;
    }

    public double getMaxSpeedPossible(Car car) {
        if (car.getPassengersPresent() != 0) {
            double coefficient = car.getWheels().stream()
                    .map(w -> w.getTire().getWearState())
                    .sorted().findFirst().get();
            return car.getMaxSpeed() * coefficient;
        }
        return 0.0;
    }
}
