package bvn.car.service.impl;

import bvn.car.dao.PassengerDao;
import bvn.car.model.Passenger;
import bvn.car.service.PassengerService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerDao passengerDao;

    public PassengerServiceImpl(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }

    @Override
    public Passenger create(Passenger passenger) {
        return passengerDao.create(passenger);
    }

    @Override
    public Passenger getById(Long passId) {
        return passengerDao.getById(passId);
    }

    @Override
    public List<Passenger> getAll() {
        return passengerDao.getAll();
    }
}
