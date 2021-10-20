package app.dao;

import app.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    private static int USER_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++USER_COUNT, "Tom"));
        users.add(new User(++USER_COUNT, "Bob"));
        users.add(new User(++USER_COUNT, "Nick"));
        users.add(new User(++USER_COUNT, "Mike"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(users -> users.getId() == id).findAny().orElse(null);
    }
}
