package bvn.car.service.impl;

import bvn.car.dao.CarDao;
import bvn.car.lib.Inject;
import bvn.car.lib.Service;
import bvn.car.model.Car;
import bvn.car.service.CarService;

@Service
public class CarServiceImpl implements CarService {
    @Inject
    private CarDao carDao;

    @Override
    public Car create(Car car) {
        return carDao.create(car);
    }
}
