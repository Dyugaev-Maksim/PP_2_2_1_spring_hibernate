package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        TypedQuery<User> query = sessionFactory
                .getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    public User getUserByCar(String model, int series) {
        Query query = sessionFactory.openSession()
                .createQuery("from User where car.model = :name" +
                        " and car.series= :series");
        query.setParameter("name", model);
        query.setParameter("series", series);
        User user = (User) query.getResultList().get(0);
        return user;
    }
}
