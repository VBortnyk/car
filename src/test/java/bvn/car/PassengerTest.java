package bvn.car;

import bvn.car.model.Car;
import bvn.car.model.Passenger;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class PassengerTest {
    private static final double DELTA = 0;
    private static Car testCar;
    private static Passenger passenger;

    @Test
    public void addPassengerValid() {
        testCar = new Car.CarBuilder().setCapacity(5).setPassengers(new ArrayList<>()).build();
        passenger = new Passenger("Passenger", 20);
        testCar.addPassenger(passenger);
        int presentPassengers = testCar.getPassengersPresent();
        Assert.assertEquals(1, presentPassengers, DELTA);
    }

    @Test
    public void addPassengersNotValid() {
        testCar = new Car.CarBuilder().setCapacity(5).setPassengers(new ArrayList<>()).build();
        int initialPassengersPresent = testCar.getPassengersPresent();
        int quantity = 10;
        while(quantity > 0) {
            passenger = new Passenger("Passenger" + quantity, 20);
            testCar.addPassenger(passenger);
            quantity--;
        }
        int resultPassengersPresent = testCar.getPassengersPresent();
        Assert.assertNotEquals(resultPassengersPresent, quantity, DELTA);
    }

    @Test
    public void dropOffPassengerValid() {
        testCar = new Car.CarBuilder().setCapacity(5).setPassengers(new ArrayList<>()).build();
        passenger = new Passenger("Passenger", 20);
        testCar.addPassenger(passenger);
        boolean ejected = testCar.dropOffPassenger(passenger);
        Assert.assertTrue(ejected);
    }

    @Test
    public void dropOffPassengerNotValid() {
        testCar = new Car.CarBuilder().setCapacity(5).setPassengers(new ArrayList<>()).build();
        Passenger passenger = new Passenger("Passenger", 20);
        boolean ejected = testCar.dropOffPassenger(passenger);
        Assert.assertFalse(ejected);
    }

}
