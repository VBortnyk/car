package bvn.car.dao;

import bvn.car.model.Wheel;
import java.util.List;

public interface WheelDao {

    Wheel create(Wheel wheel);

    Wheel getById(Long wheelId);

    List<Wheel> getAll();
}
