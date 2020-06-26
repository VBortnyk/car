package bvn.car.dao.jdbc;

import bvn.car.dao.TireDao;
import bvn.car.exceptions.DataProcessingException;
import bvn.car.lib.Dao;
import bvn.car.model.Tire;
import bvn.car.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class TireDaoImpl implements TireDao {
    @Override
    public Tire create(Tire tire) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Long id = (Long) session.save(tire);
            tire.setId(id);
            return tire;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.commit();
            }
            throw new DataProcessingException("Failed to create tire", e);
        }
    }
}
