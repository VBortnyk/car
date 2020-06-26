package bvn.car.dao.jdbc;

import bvn.car.dao.DoorDao;
import bvn.car.exceptions.DataProcessingException;
import bvn.car.lib.Dao;
import bvn.car.model.Door;
import bvn.car.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class DoorDaoImpl implements DoorDao {
    @Override
    public Door create(Door door) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Long id = (Long) session.save(door);
            transaction.commit();
            door.setId(id);
            return door;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Failed to crete door", e);
        }
    }
}
