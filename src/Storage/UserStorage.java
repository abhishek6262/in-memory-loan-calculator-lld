package Storage;

import Entities.User;
import java.util.HashMap;
import java.util.Map;

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

    public <T extends User> T get(String username) {
        return (T) users.get(username);
    }

    public static UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }

        return instance;
    }
}
