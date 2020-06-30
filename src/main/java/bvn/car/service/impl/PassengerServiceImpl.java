package bvn.car.service.impl;

import bvn.car.dao.PassengerDao;
import bvn.car.lib.Inject;
import bvn.car.lib.Service;
import bvn.car.model.Passenger;
import bvn.car.service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Inject
    private PassengerDao passengerDao;

    @Override
    public Passenger create(Passenger passenger) {
        return passengerDao.create(passenger);
    }
}
