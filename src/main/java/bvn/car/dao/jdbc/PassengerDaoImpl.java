package bvn.car.dao.jdbc;

import bvn.car.dao.PassengerDao;
import bvn.car.exceptions.DataProcessingException;
import bvn.car.lib.Dao;
import bvn.car.model.Passenger;
import bvn.car.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class PassengerDaoImpl implements PassengerDao {
    @Override
    public Passenger create(Passenger passenger) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Long id = (Long) (session.save(passenger));
            transaction.commit();
            passenger.setId(id);
            return passenger;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Failed to crete door", e);
        }
    }
}
