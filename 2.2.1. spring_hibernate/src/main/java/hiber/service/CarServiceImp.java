package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarServiceImp implements CarService {
    private final SessionFactory sessionFactory;
    private final CarDao carDao;

    public CarServiceImp(SessionFactory sessionFactory, CarDao carDao) {
        this.sessionFactory = sessionFactory;
        this.carDao = carDao;
    }


    @Override
    public void addCar(Car car) {
        carDao.addCar(car);
    }

    @Override
    public List<User> getCar() {
        return null;
    }

    @Override
    public User getUserByCar(String model, int series) {
        return carDao.getUserByCar(model, series);
    }
}
