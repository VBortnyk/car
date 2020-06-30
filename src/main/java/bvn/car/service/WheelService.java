package bvn.car.service;

import bvn.car.model.Wheel;
import java.util.List;

public interface WheelService {

    Wheel create(Wheel wheel);

    Wheel getById(Long wheelId);

    List<Wheel> getAll();
}
