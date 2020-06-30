package bvn.car;

import bvn.car.model.Car;
import bvn.car.model.Door;
import bvn.car.model.Passenger;
import bvn.car.model.Tire;
import bvn.car.model.Wheel;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CarTest {
    private static final double DELTA = 0;
    private static Car testCar;

    @Test
    public void openDoorValid() {
        Door door = new Door("Audi");
        boolean closed = door.isClosed();
        Assert.assertTrue(closed);
    }

    @Test
    public void openDoorNotValid() {
        Door door = new Door("Audi");
        boolean closed = door.isClosed();
        Assert.assertFalse(!closed);
    }

    @Test
    public void changeCurrentSpeedValid() {
        testCar = new Car.CarBuilder().setMaxSpeed(280).build();
        int initialSpeed = testCar.getCurrentSpeed();
        int currentSpeed = testCar.changeCurrentSpeed(20);
        Assert.assertEquals(initialSpeed + 20, currentSpeed);
    }

    @Test
    public void changeCurrentSpeedNotValid() {
        testCar = new Car.CarBuilder().build();
        int initialSpeed = testCar.getCurrentSpeed();
        int currentSpeed = testCar.changeCurrentSpeed(300);
        Assert.assertNotEquals(initialSpeed + 20, currentSpeed);
    }

    @Test
    public void changeCurrentSpeedToNegativeValueValid() {
        testCar = new Car.CarBuilder().build();
        int initialSpeed = testCar.getCurrentSpeed();
        int currentSpeed = testCar.changeCurrentSpeed(-20);
        Assert.assertNotEquals(initialSpeed - 20, currentSpeed);
    }

    @Test
    public void getMaxSpeedPossibleValid() {
        testCar = new Car.CarBuilder().setWheels(new ArrayList<>()).build();
        testCar.setPassengers(new ArrayList<>());
        Passenger driver = new Passenger("Driver", 20);
        testCar.addPassenger(driver);
        double wearState = 0.8;
        while (testCar.getWheels().size() < 4) {
            Tire tire = new Tire(wearState, "GoodYear", 16);
            Wheel wheel = new Wheel( 16, tire);
            testCar.getWheels().add(wheel);
        }
        double expectedSpeedPossible = testCar.getMaxSpeed() * wearState;
        double currentSpeedPossible = testCar.getMaxSpeedPossible();
        Assert.assertEquals(expectedSpeedPossible, currentSpeedPossible, DELTA);
    }

    @Test
    public void getMaxSpeedPossibleNotValid() {
        try {
            testCar = new Car.CarBuilder().setWheels(new ArrayList<>()).build();
            double wearState = 0.8;
            while (testCar.getWheels().size() < 4) {
                Tire tire = new Tire(wearState, "GoodYear", 16);
                Wheel wheel = new Wheel(16, tire);
                testCar.getWheels().add(wheel);
            }
        } catch (NullPointerException e) {
            return;
        }
        System.out.println("NullPointerException expected! Car can not drive without a driver");
    }
}
