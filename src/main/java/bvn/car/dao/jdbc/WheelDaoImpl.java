package bvn.car.dao.jdbc;

import bvn.car.dao.WheelDao;
import bvn.car.exceptions.DataProcessingException;
import bvn.car.model.Wheel;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class WheelDaoImpl implements WheelDao {

    private final SessionFactory sessionFactory;

    public WheelDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Wheel create(Wheel wheel) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Long id = (Long) session.save(wheel);
            transaction.commit();
            wheel.setId(id);
            return wheel;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Failed to add wheel", e);
        }
    }

    @Override
    public Wheel getById(Long wheelId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Wheel.class, wheelId);
        } catch (Exception e) {
            throw new DataProcessingException("Failed to get wheel with id: " + wheelId, e);
        }
    }

    @Override
    public List<Wheel> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Wheel> query = session.createQuery("From Wheel", Wheel.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Failed to get all wheels", e);
        }
    }
}
