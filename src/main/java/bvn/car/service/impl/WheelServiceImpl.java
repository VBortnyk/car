package bvn.car.service.impl;

import bvn.car.dao.WheelDao;
import bvn.car.lib.Inject;
import bvn.car.lib.Service;
import bvn.car.model.Wheel;
import bvn.car.service.WheelService;

@Service
public class WheelServiceImpl implements WheelService {
    @Inject
    private WheelDao wheelDao;

    @Override
    public Wheel create(Wheel wheel) {
        return wheelDao.create(wheel);
    }
}
