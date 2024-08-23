package Storage;

import Entities.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserStorage {
    private static UserStorage instance;

    Map<String, User> users = new HashMap<>();

    private UserStorage() {}

    public <T extends User> void create(T user) {
        users.put(user.username, user);
    }

    public boolean exists(String username) {
        return users.containsKey(username);
    }

    public <T extends User> Optional<T> get(String username) {
        return Optional.ofNullable((T) users.get(username));
    }

    public static UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }

        return instance;
    }
}
