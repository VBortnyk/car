package bvn.car.dao;

import bvn.car.model.Door;
import java.util.List;

public interface DoorDao {

    Door create(Door door);

    Door getById(Long doorId);

    List<Door> getAll();
}
