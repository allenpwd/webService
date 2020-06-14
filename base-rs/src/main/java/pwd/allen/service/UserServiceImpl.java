package pwd.allen.service;

import pwd.allen.entity.Car;
import pwd.allen.entity.User;

import java.util.Collections;
import java.util.Date;

/**
 * @author 门那粒沙
 * @create 2020-06-14 10:05
 **/
public class UserServiceImpl implements IUserService {
    @Override
    public User getUser(Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("门那粒沙");
        user.setBirthAt(new Date());

        Car car = new Car();
        car.setName("蔚来 ES6");
        car.setPrice(375835.55);

        user.setCars(Collections.singletonList(car));
        return user;
    }
}
