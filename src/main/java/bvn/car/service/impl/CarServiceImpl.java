package bvn.car.service.impl;

import bvn.car.dao.CarDao;
import bvn.car.model.Car;
import bvn.car.service.CarService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public Car create(Car car) {
        return carDao.create(car);
    }

    @Override
    public Car getById(Long carId) {
        return carDao.getById(carId);
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }
}
