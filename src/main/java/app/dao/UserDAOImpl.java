package app.dao;

import app.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    private static int USER_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++USER_COUNT, "Tom", "White", "tomwhite@gmail.com", 37));
        users.add(new User(++USER_COUNT, "Bob", "Black", "babblack@gmail.com",25));
        users.add(new User(++USER_COUNT, "Nick", "Green", "nickgreen@gmail.com", 14));
        users.add(new User(++USER_COUNT, "Mike", "Macferson", "mikemacferson@gmail.com",10));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(users -> users.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++USER_COUNT);
        users.add(user);
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurName(updatedUser.getSurName());
        userToBeUpdated.setEmail(updatedUser.getEmail());
        userToBeUpdated.setAge(updatedUser.getAge());
    }

    public void delete(int id) {
        users.removeIf(u -> u.getId() == id);
    }
}
