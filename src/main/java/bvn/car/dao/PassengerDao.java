package bvn.car.dao;

import bvn.car.model.Passenger;
import java.util.List;

public interface PassengerDao {

    Passenger create(Passenger passenger);

    Passenger getById(Long passId);

    List<Passenger> getAll();

}
