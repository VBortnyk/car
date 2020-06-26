package bvn.car.service.impl;

import bvn.car.dao.TireDao;
import bvn.car.lib.Inject;
import bvn.car.lib.Service;
import bvn.car.model.Tire;
import bvn.car.service.TireService;

@Service
public class TireServiceImpl implements TireService {
    @Inject
    private TireDao tireDao;

    @Override
    public Tire create(Tire tire) {
        return tireDao.create(tire);
    }
}
