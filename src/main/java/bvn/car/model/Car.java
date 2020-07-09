package bvn.car.model;

import bvn.car.interfaces.Movable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cars")
public class Car implements Movable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private LocalDate manufactureDate;
    private String engineType;
    private int maxSpeed;
    @Transient
    private int currentSpeed;
    private double accelerationTime;
    private int capacity;
    private int passengersPresent;
    @OneToMany
    private List<Passenger> passengers;
    @OneToMany
    private List<Wheel> wheels;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Door> doors;

    public boolean addPassenger(Passenger passenger) {
        if (passengersPresent == capacity) {
            return false;
        }
        passengers.add(passenger);
        passengersPresent++;
        return true;
    }

    @Override
    public void move() {
        System.out.println("I'm driving on the road");
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
            Tire tire = new Tire(1, "someProducer", 16);
            Wheel wheel = new Wheel(16, tire);
            wheels.add(wheel);
            quantity--;
        }
    }

    public int changeCurrentSpeed(int changeValue) {
        if (currentSpeed + changeValue > maxSpeed) {
            currentSpeed = maxSpeed;
            return currentSpeed;
        }
        if (currentSpeed + changeValue < 0) {
            currentSpeed = 0;
            return 0;
        }
        return currentSpeed + changeValue;
    }

    public double getMaxSpeedPossible() {
        if (passengers == null || passengers.size() != 0) {
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
        return passengers.size();
    }

    public void setPassengersPresent(int passengersPresent) {
        this.passengersPresent = passengersPresent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
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

        public CarBuilder setDoors(List<Door> doors) {
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
                && Objects.equals(getDoors(), car.getDoors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getManufactureDate(),
                getEngineType(), getMaxSpeed(), getCurrentSpeed(), getAccelerationTime(),
                getCapacity(), getPassengersPresent(), getPassengers(), getWheels(), getDoors());
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
                + ", doors=" + doors
                + '}';
    }
}
