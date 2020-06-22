package bvn.car;

import bvn.car.model.Car;
import bvn.car.model.Door;
import bvn.car.model.Passenger;
import bvn.car.model.Tire;
import bvn.car.model.Wheel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TestCar {
    private static final double DELTA = 0;
    private static Car testCar;

    @BeforeClass
    public static void createCar() {

        testCar = new Car.CarBuilder()
                .setCapacity(5)
                .setPassengers(new ArrayList<>())
                .setWheels(new ArrayList<>())
                .setDoors(new Door[0])
                .build();
    }

    @Test
    public void addPassengerValid() {
        testCar.addPassenger(new Passenger("Passenger", 20));
        int presentPassengers = testCar.getPassengersPresent();
        Assert.assertEquals(1, presentPassengers, DELTA);
    }

    @Test
    public void addPassengersNotValid() {
        testCar.addPassenger(new Passenger("Passenger", 20));
        int passengersPresent = testCar.getPassengersPresent();
        Assert.assertNotEquals(1, passengersPresent, DELTA);
    }

    @Test
    public void dropOffPassengerValid() {
        Passenger passenger = new Passenger("Passenger", 20);
        boolean ejected = testCar.dropOffPassenger(passenger);
        Assert.assertTrue(ejected);
    }

    @Test
    public void dropOffPassengerNotValid() {
        Passenger passenger = new Passenger("Passenger", 20);
        boolean ejected = testCar.dropOffPassenger(passenger);
        Assert.assertFalse(ejected);
    }

    @Test
    public void addWheelsValid() {
        Tire tire = new Tire(1, "GoodYear", 16);
        Wheel wheel = new Wheel((long) testCar.getWheels().size() + 1, 16, tire);
        testCar.getWheels().add(wheel);
        int result = testCar.getWheels().size();
        Assert.assertEquals(1, result, DELTA);
    }

    @Test
    public void addWheelsNotValid() {
        Tire tire = new Tire(1, "GoodYear", 16);
        Wheel wheel = new Wheel((long) testCar.getWheels().size() + 1, 16, tire);
        testCar.getWheels().add(wheel);
        int result = testCar.getWheels().size();
        Assert.assertNotEquals(0, result, DELTA);
    }

    @Test
    public void dismantleWheelsValid() {
        Tire tire = new Tire(1, "GoodYear", 16);
        Wheel wheel = new Wheel((long) testCar.getWheels().size() + 1, 16, tire);
        testCar.getWheels().add(wheel);
        testCar.getWheels().add(wheel);
        List<Wheel> dismantledWheels = testCar.dismantleAllWheels();
        int count = dismantledWheels.size();
        Assert.assertEquals(2, count, DELTA);
    }

    @Test
    public void dismantleWheelsNotValid() {
        Tire tire = new Tire(1, "GoodYear", 16);
        Wheel wheel = new Wheel((long) testCar.getWheels().size() + 1, 16, tire);
        testCar.getWheels().add(wheel);
        testCar.getWheels().add(wheel);
        List<Wheel> dismantledWheels = testCar.dismantleAllWheels();
        int count = dismantledWheels.size();
        Assert.assertNotEquals(0, count, DELTA);
    }

    @Test
    public void openDoorValid() {
        Door door = new Door(1, Door.DoorMarker.FRONT_RIGHT, "Audi");
        boolean closed = door.isClosed();
        Assert.assertFalse(closed);
    }
}
