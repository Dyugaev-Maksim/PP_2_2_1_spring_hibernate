package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImp implements CarDao {
    private final SessionFactory sessionFactory;

    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> getCar() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Car");
        return query.getResultList();

    }
}
