package bvn.car.dao.jdbc;

import bvn.car.dao.WheelDao;
import bvn.car.exceptions.DataProcessingException;
import bvn.car.lib.Dao;
import bvn.car.model.Wheel;
import bvn.car.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class WheelDaoImpl implements WheelDao {
    @Override
    public Wheel create(Wheel wheel) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(wheel);
            return wheel;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Failed to add wheel", e);
        }
    }
}
