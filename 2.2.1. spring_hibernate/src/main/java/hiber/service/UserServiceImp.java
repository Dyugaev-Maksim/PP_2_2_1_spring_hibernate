package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class UserServiceImp implements UserService {
    private final SessionFactory sessionFactory;
    private final UserDao userDao;

    public UserServiceImp(SessionFactory sessionFactory, UserDao userDao) {
        this.sessionFactory = sessionFactory;
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void addCar(Car car) {
        userDao.addCar(car);
    }

    @Transactional
    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public User getUserByCar(String model, int series) {
        Query query = sessionFactory.openSession().createQuery("from User where car.model = :name and car.series= :series");
        query.setParameter("name", model);
        query.setParameter("series", series);
        User user = (User) query.getResultList().get(0);
        return user;
    }


}
