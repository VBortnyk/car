package bvn.car.dao.jdbc;

import bvn.car.dao.TireDao;
import bvn.car.exceptions.DataProcessingException;
import bvn.car.model.Tire;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class TireDaoImpl implements TireDao {

    private final SessionFactory sessionFactory;

    public TireDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Tire create(Tire tire) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Long id = (Long) session.save(tire);
            transaction.commit();
            tire.setId(id);
            return tire;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Failed to create tire", e);
        }
    }

    @Override
    public Tire getByID(Long tireId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Tire.class, tireId);
        } catch (Exception e) {
            throw new DataProcessingException("Failed to get tire with id: " + tireId, e);
        }
    }

    @Override
    public List<Tire> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Tire> query = session.createQuery("FROM Tire", Tire.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Failed to get all tires", e);
        }
    }
}
