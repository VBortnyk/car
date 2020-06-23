package bvn.car;

import bvn.car.model.Car;
import bvn.car.model.Tire;
import bvn.car.model.Wheel;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WheelTest {
    private static final double DELTA = 0;
    private static Car testCar;

    @Test
    public void getWheelByIndexValid() {
        testCar = new Car.CarBuilder().setWheels(new ArrayList<>()).build();
        while (testCar.getWheels().size() < 4) {
            Tire tire = new Tire(1, "GoodYear", 16);
            Wheel wheel = new Wheel((long) testCar.getWheels().size() + 1, 16, tire);
            testCar.getWheels().add(wheel);
        }
        Tire tire = new Tire( 1, "GoodYear", 16);
        Wheel wheel = new Wheel((long) testCar.getWheels().size(), 16, tire);
        Wheel wheelFromCar = testCar.getWheelByIndex(4L);
        Assert.assertEquals(wheel, wheelFromCar);
    }

    @Test
    public void getWheelByIndexNotValid() {
        testCar = new Car.CarBuilder().setWheels(new ArrayList<>()).build();
        while (testCar.getWheels().size() < 4) {
            Tire tire = new Tire(1, "GoodYear", 16);
            Wheel wheel = new Wheel((long) testCar.getWheels().size() + 1, 16, tire);
            testCar.getWheels().add(wheel);
        }
        Tire tire = new Tire( 1, "GoodYear", 16);
        Wheel wheel = new Wheel((long) testCar.getWheels().size() + 1, 16, tire);
        Wheel wheelFromCar = testCar.getWheelByIndex(4L);
        Assert.assertNotEquals(wheel, wheelFromCar);
    }

    @Test
    public void addWheelsValid() {
        testCar = new Car.CarBuilder().setWheels(new ArrayList<>()).build();
        testCar.addWheels(4);
        int result = testCar.getWheels().size();
        Assert.assertEquals(4, result, DELTA);
    }

    @Test
    public void addWheelsNotValid() {
        testCar = new Car.CarBuilder().setWheels(new ArrayList<>()).build();
        testCar.addWheels(4);
        int result = testCar.getWheels().size();
        Assert.assertNotEquals(5, result, DELTA);
    }

    @Test
    public void dismantleWheelsValid() {
        testCar = new Car.CarBuilder().setWheels(new ArrayList<>()).build();
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
        testCar = new Car.CarBuilder().setWheels(new ArrayList<>()).build();
        Tire tire = new Tire(1, "GoodYear", 16);
        Wheel wheel = new Wheel((long) testCar.getWheels().size() + 1, 16, tire);
        testCar.getWheels().add(wheel);
        testCar.getWheels().add(wheel);
        List<Wheel> dismantledWheels = testCar.dismantleAllWheels();
        int count = dismantledWheels.size();
        Assert.assertNotEquals(0, count, DELTA);
    }
}
