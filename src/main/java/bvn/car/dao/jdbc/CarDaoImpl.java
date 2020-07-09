package bvn.car.dao.jdbc;

import bvn.car.dao.CarDao;
import bvn.car.exceptions.DataProcessingException;
import bvn.car.model.Car;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao {

    private final SessionFactory sessionFactory;

    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Car create(Car car) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
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

    @Override
    public Car getById(Long carId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Car.class, carId);
        } catch (Exception e) {
            throw new DataProcessingException("Failed to get car with id: " + carId, e);
        }
    }

    @Override
    public List<Car> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Car> query = session.createQuery("FROM Car", Car.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Failed to get all cars from DB", e);
        }
    }
}
