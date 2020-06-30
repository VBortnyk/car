package bvn.car.service;

import bvn.car.model.Tire;
import java.util.List;

public interface TireService {

    Tire create(Tire tire);

    Tire findById(Long tireId);

    List<Tire> getAll();
}
