package bvn.car.dao;

import bvn.car.model.Car;
import java.util.List;

public interface CarDao {

    Car create(Car car);

    Car getById(Long id);

    List<Car> getAll();
}
