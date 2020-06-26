package bvn.car.service.impl;

import bvn.car.dao.DoorDao;
import bvn.car.lib.Inject;
import bvn.car.lib.Service;
import bvn.car.model.Door;
import bvn.car.service.DoorService;

@Service
public class DoorServiceImpl implements DoorService {
    @Inject
    private DoorDao doorDao;

    @Override
    public Door create(Door door) {
        return doorDao.create(door);
    }
}
