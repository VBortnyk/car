package bvn.car.service.impl;

import bvn.car.dao.WheelDao;
import bvn.car.model.Wheel;
import bvn.car.service.WheelService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WheelServiceImpl implements WheelService {

    private final WheelDao wheelDao;

    public WheelServiceImpl(WheelDao wheelDao) {
        this.wheelDao = wheelDao;
    }

    @Override
    public Wheel create(Wheel wheel) {
        return wheelDao.create(wheel);
    }

    @Override
    public Wheel getById(Long wheelId) {
        return wheelDao.getById(wheelId);
    }

    @Override
    public List<Wheel> getAll() {
        return wheelDao.getAll();
    }
}
