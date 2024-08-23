package Services;

import Entities.Admin;
import Entities.Customer;
import Entities.Loan;
import Repositories.EmiRepository;
import Repositories.LoanRepository;
import Repositories.UserRepository;

import java.util.Optional;

public class LoanService {
    private final EmiRepository emiRepository = new EmiRepository();
    private final LoanRepository loanRepository = new LoanRepository();
    private final UserRepository userRepository = new UserRepository();

    public Loan createLoan(String adminUsername, String customerUsername, Float principal, Float interestRate, Integer tenureInMonths) {
        Optional<Admin> admin = userRepository.getByUsername(adminUsername);
        Optional<Customer> customer = userRepository.getByUsername(customerUsername);

        if (admin.isEmpty()) {
            throw new IllegalArgumentException("Admin does not exist");
        } else if (customer.isEmpty()) {
            throw new IllegalArgumentException("Customer does not exist");
        }

        Loan loan = new Loan(admin.get(), customer.get(), principal, interestRate, tenureInMonths);

        loanRepository.create(loan);
        emiRepository.registerEmisForLoan(loan);

        return loan;
    }
}
