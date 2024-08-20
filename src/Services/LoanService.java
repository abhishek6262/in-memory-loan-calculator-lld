package Services;

import Entities.Admin;
import Entities.Customer;
import Entities.Loan;
import Repositories.EmiRepository;
import Repositories.LoanRepository;
import Repositories.UserRepository;

public class LoanService {
    private final EmiRepository emiRepository = new EmiRepository();
    private final LoanRepository loanRepository = new LoanRepository();
    private final UserRepository userRepository = new UserRepository();

    public Loan createLoan(String adminUsername, String customerUsername, Float principal, Float interestRate, Integer tenureInMonths) {
        if (!userRepository.exists(adminUsername)) {
            throw new IllegalArgumentException("Admin does not exist");
        } else if (!userRepository.exists(customerUsername)) {
            throw new IllegalArgumentException("Customer does not exist");
        }

        Admin admin = userRepository.getWithUsername(adminUsername);
        Customer customer = userRepository.getWithUsername(customerUsername);

        Loan loan = new Loan(admin, customer, principal, interestRate, tenureInMonths);

        loanRepository.create(loan);
        emiRepository.registerEmisForLoan(loan);

        return loan;
    }
}
