package bvn.car.service.impl;

import bvn.car.dao.TireDao;
import bvn.car.model.Tire;
import bvn.car.service.TireService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TireServiceImpl implements TireService {

    private final TireDao tireDao;

    public TireServiceImpl(TireDao tireDao) {
        this.tireDao = tireDao;
    }

    @Override
    public Tire create(Tire tire) {
        return tireDao.create(tire);
    }

    @Override
    public Tire findById(Long tireId) {
        return tireDao.getByID(tireId);
    }

    @Override
    public List<Tire> getAll() {
        return tireDao.getAll();
    }
}
