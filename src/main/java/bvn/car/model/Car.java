package bvn.car.model;

import bvn.car.Transport;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Car extends Transport {
    private String brand;
    private String model;
    private LocalDate manufactureDate;
    private String engineType;
    private int maxSpeed;
    private int currentSpeed;
    private double accelerationTime;
    private int capacity;
    private int passengersPresent;
    private List<Passenger> passengers;
    private List<Wheel> wheels;
    private Door[] doors;

    @Override
    public void move() {
        System.out.println("I'm riding on the road");
    }

    public int changeCurrentSpeed(int changeValue) {
        if (currentSpeed + changeValue > maxSpeed) {
            currentSpeed = maxSpeed;
            return currentSpeed;
        }
        if (currentSpeed - changeValue < 0) {
            currentSpeed = 0;
            return currentSpeed;
        }
        return currentSpeed + changeValue;
    }

    public boolean addPassenger(Passenger passenger) {
        if (passengersPresent == capacity) {
            return false;
        }
        passengers.add(passenger);
        passengersPresent++;
        return true;
    }

    public boolean dropOffPassenger(Passenger passenger) {
        return passengers.removeIf(passenger::equals);
    }

    public List<Passenger> clearPassengers() {
        List<Passenger> removedPassengers = passengers;
        passengers.clear();
        return removedPassengers;
    }

    public Wheel getWheelByIndex(Long index) {
        try {
            return wheels.stream().filter(w -> w.getId().equals(index)).findFirst().get();
        } catch (NullPointerException e) {
            System.out.println("No wheel with id: " + index + "found");
        }
        return null;
    }

    public List<Wheel> dismantleAllWheels() {
        List<Wheel> dismantledWheels = new ArrayList<>(this.wheels);
        this.wheels.clear();
        return dismantledWheels;
    }

    public void addWheels(int quantity) {
        while (quantity > 0) {
            int currentRadius = wheels.get(1).getRadius();
            Tire tire = new Tire(1, "someProducer", currentRadius);
            Wheel wheel = new Wheel((long) this.wheels.size(), currentRadius, tire);
            wheels.add(wheel);
            quantity--;
        }
    }

    public double getMaxSpeedPossible() {
        if (passengers.size() != 0) {
            double coefficient = wheels.stream()
                    .map(w -> w.getTire().getWearState())
                    .sorted().findFirst().get();
            return maxSpeed * coefficient;
        }
        return 0.0;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public double getAccelerationTime() {
        return accelerationTime;
    }

    public void setAccelerationTime(double accelerationTime) {
        this.accelerationTime = accelerationTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPassengersPresent() {
        return passengersPresent;
    }

    public void setPassengersPresent(int passengersPresent) {
        this.passengersPresent = passengersPresent;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public Door[] getDoors() {
        return doors;
    }

    public void setDoors(Door[] doors) {
        this.doors = doors;
    }

    public static class CarBuilder {
        private Car newCar;

        public CarBuilder() {
            newCar = new Car();
        }

        public CarBuilder setBrand(String brand) {
            newCar.brand = brand;
            return this;
        }

        public CarBuilder setModel(String model) {
            newCar.model = model;
            return this;
        }

        public CarBuilder setManufactureDate(LocalDate manufactureDate) {
            newCar.manufactureDate = manufactureDate;
            return this;
        }

        public CarBuilder setEngineType(String engineType) {
            newCar.engineType = engineType;
            return this;
        }

        public CarBuilder setMaxSpeed(int maxSpeed) {
            newCar.maxSpeed = maxSpeed;
            return this;
        }

        public CarBuilder setAccelerationTime(double accelerationTime) {
            newCar.accelerationTime = accelerationTime;
            return this;
        }

        public CarBuilder setCapacity(int capacity) {
            newCar.capacity = capacity;
            return this;
        }

        public CarBuilder setPassengers(List<Passenger> passengers) {
            newCar.passengers = passengers;
            return this;
        }

        public CarBuilder setPassengersPresent() {
            newCar.setPassengersPresent(newCar.passengers.size());
            return this;
        }

        public CarBuilder setWheels(List<Wheel> wheels) {
            newCar.wheels = wheels;
            return this;
        }

        public CarBuilder setDoors(Door[] doors) {
            newCar.doors = doors;
            return this;
        }

        public Car build() {
            return newCar;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(getBrand(), car.getBrand())
                && Objects.equals(getModel(), car.getModel())
                && getMaxSpeed() == car.getMaxSpeed()
                && getCurrentSpeed() == car.getCurrentSpeed()
                && Double.compare(car.getAccelerationTime(), getAccelerationTime()) == 0
                && getCapacity() == car.getCapacity()
                && getPassengersPresent() == car.getPassengersPresent()
                && Objects.equals(getManufactureDate(), car.getManufactureDate())
                && Objects.equals(getEngineType(), car.getEngineType())
                && Objects.equals(getPassengers(), car.getPassengers())
                && Objects.equals(getWheels(), car.getWheels())
                && Arrays.equals(getDoors(), car.getDoors());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getManufactureDate(), getEngineType(),
                getMaxSpeed(), getCurrentSpeed(), getAccelerationTime(),
                getCapacity(), getPassengersPresent(), getPassengers(), getWheels());
        result = 31 * result + Arrays.hashCode(getDoors());
        return result;
    }

    @Override
    public String toString() {
        return "Car{"
                + "brand=" + brand
                + ", model=" + model
                + ", manufactureDate=" + manufactureDate + "\n"
                + ", engineType='" + engineType
                + ", initialMaxSpeed=" + maxSpeed
                + ", max speed possible=" + getMaxSpeedPossible()
                + ", currentSpeed=" + currentSpeed
                + ", accelerationTime=" + accelerationTime + "\n"
                + ", capacity=" + capacity
                + ", passengersPresent=" + passengersPresent
                + ", passengers=" + passengers + "\n"
                + ", wheels=" + wheels + "\n"
                + ", doors=" + Arrays.toString(doors)
                + '}';
    }
}
