package bvn.car.dao;

import bvn.car.model.Tire;
import java.util.List;

public interface TireDao {

    Tire create(Tire tire);

    Tire getByID(Long tireId);

    List<Tire> getAll();
}
