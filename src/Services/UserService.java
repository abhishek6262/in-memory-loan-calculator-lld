package Services;

import Entities.Admin;
import Entities.Customer;
import Repositories.UserRepository;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public Admin createAdmin(String username, String name) {
        if (userRepository.exists(username)) {
            throw new IllegalArgumentException("Username already exists");
        }

        Admin admin = new Admin(username, name);

        return userRepository.create(admin);
    }

    public Customer createCustomer(String username, String name) {
        if (userRepository.exists(username)) {
            throw new IllegalArgumentException("Username already exists");
        }

        Customer customer = new Customer(username, name);

        return userRepository.create(customer);
    }
}
