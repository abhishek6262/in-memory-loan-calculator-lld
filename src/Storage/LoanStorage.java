package Storage;

import Entities.Loan;
import Entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoanStorage {
    private static LoanStorage instance;

    HashMap<User, List<Loan>> customerLoans = new HashMap<>();

    private LoanStorage() {}

    public void create(Loan loan) {
        List<Loan> customerLoansGroup = customerLoans.computeIfAbsent(loan.customer, k -> new ArrayList<>());

        customerLoansGroup.add(loan);
    }

    public static LoanStorage getInstance() {
        if (instance == null) {
            instance = new LoanStorage();
        }

        return instance;
    }
}
