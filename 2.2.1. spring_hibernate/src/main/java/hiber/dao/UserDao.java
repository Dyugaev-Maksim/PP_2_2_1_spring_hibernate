package hiber.dao;

import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    List<User> getUsers();

    User getUserByCar(String model, int series);
}
