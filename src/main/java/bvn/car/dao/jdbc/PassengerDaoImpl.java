package bvn.car.dao.jdbc;

import bvn.car.dao.PassengerDao;
import bvn.car.exceptions.DataProcessingException;
import bvn.car.model.Passenger;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PassengerDaoImpl implements PassengerDao {

    private final SessionFactory sessionFactory;

    public PassengerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Passenger create(Passenger passenger) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
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

    @Override
    public Passenger getById(Long passId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Passenger.class, passId);
        } catch (Exception e) {
            throw new DataProcessingException("Failed to get passenger with id: " + passId, e);
        }
    }

    @Override
    public List<Passenger> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Passenger> passengerQuery = session.createQuery(
                    "FROM Passenger", Passenger.class);
            return passengerQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Failed to get list of passengers", e);
        }
    }
}
