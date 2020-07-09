package bvn.car.service;

import bvn.car.model.Passenger;
import java.util.List;

public interface PassengerService {

    Passenger create(Passenger passenger);

    Passenger getById(Long passId);

    List<Passenger> getAll();
}
