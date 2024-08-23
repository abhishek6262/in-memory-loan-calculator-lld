package Services;

import Entities.*;
import Enums.EmiStatus;
import Repositories.EmiRepository;
import Repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class EmiService {
    private final EmiRepository emiRepository = new EmiRepository();
    private final UserRepository userRepository = new UserRepository();

    public void payEmi(String username, Loan loan) {
        Emi emi = getLoanUnpaidEmis(username, loan).getFirst();
        emi.markPaid();
    }

    public List<Emi> getLoanUnpaidEmis(String username, Loan loan) {
        List<Emi> emis = getLoanAllEmis(username, loan);

        return emis.stream().filter(e -> e.status == EmiStatus.UNPAID).toList();
    }

    public List<Emi> getLoanPaidEmis(String username, Loan loan) {
        List<Emi> emis = getLoanAllEmis(username, loan);

        return emis.stream().filter(e -> e.status == EmiStatus.PAID).toList();
    }

    public List<Emi> getLoanAllEmis(String username, Loan loan) {
        Optional<User> user = userRepository.getByUsername(username);

        if (user.isEmpty()) {
            throw new IllegalArgumentException("User does not exist");
        }

        Customer customer = loan.customer;

        if (!(user.get() instanceof Admin) && !customer.username.equals(username)) {
            throw new IllegalArgumentException("User does not have permission");
        }

        return emiRepository.getByLoan(loan);
    }
}
