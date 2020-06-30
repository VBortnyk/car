package bvn.car.dao.jdbc;

import bvn.car.dao.DoorDao;
import bvn.car.exceptions.DataProcessingException;
import bvn.car.model.Door;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class DoorDaoImpl implements DoorDao {

    private final SessionFactory sessionFactory;

    public DoorDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Door create(Door door) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
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

    @Override
    public Door getById(Long doorId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Door.class, doorId);
        } catch (Exception e) {
            throw new DataProcessingException("Failed to get door by id: " + doorId, e);
        }
    }

    @Override
    public List<Door> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Door> query = session.createQuery("FROM Door", Door.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Failed to get all doors", e);
        }
    }
}
