package Repositories;

import Entities.User;
import Storage.UserStorage;

public class UserRepository {
    private final UserStorage userStorage = UserStorage.getInstance();

    public boolean exists(String username) {
        return userStorage.exists(username);
    }

    public <T extends User> T create(T user) {
        userStorage.create(user);

        return user;
    }

    public <T extends User> T getWithUsername(String username) {
        return userStorage.get(username);
    }
}
