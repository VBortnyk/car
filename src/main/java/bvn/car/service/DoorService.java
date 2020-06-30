package bvn.car.service;

import bvn.car.model.Door;
import java.util.List;

public interface DoorService {

    Door create(Door door);

    Door getById(Long doorId);

    List<Door> getAll();
}
