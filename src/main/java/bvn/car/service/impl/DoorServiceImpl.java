package bvn.car.service.impl;

import bvn.car.dao.DoorDao;
import bvn.car.model.Door;
import bvn.car.service.DoorService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DoorServiceImpl implements DoorService {

    private final DoorDao doorDao;

    public DoorServiceImpl(DoorDao doorDao) {
        this.doorDao = doorDao;
    }

    @Override
    public Door create(Door door) {
        return doorDao.create(door);
    }

    @Override
    public Door getById(Long doorId) {
        return doorDao.getById(doorId);
    }

    @Override
    public List<Door> getAll() {
        return doorDao.getAll();
    }
}
