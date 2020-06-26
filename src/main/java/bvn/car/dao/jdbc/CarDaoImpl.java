package bvn.car.dao.jdbc;

import bvn.car.dao.CarDao;
import bvn.car.exceptions.DataProcessingException;
import bvn.car.lib.Dao;
import bvn.car.model.Car;
import bvn.car.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class CarDaoImpl implements CarDao {
    @Override
    public Car create(Car car) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Long id = (Long) (session.save(car));
            transaction.commit();
            car.setId(id);
            return car;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Failed to add car with id: " + car.getId(), e);
        }
    }
}
