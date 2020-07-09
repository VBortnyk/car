package bvn.car.service;

import bvn.car.model.Car;
import java.util.List;

public interface CarService {

    Car create(Car car);

    Car getById(Long id);

    List<Car> getAll();
}
