package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getUsers();

    public User getUserByCar(String model, int series);
}
