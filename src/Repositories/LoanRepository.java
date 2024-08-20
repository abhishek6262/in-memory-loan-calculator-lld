package Repositories;

import Entities.Loan;
import Storage.LoanStorage;

public class LoanRepository {
    private final LoanStorage loanStorage = LoanStorage.getInstance();

    public Loan create(Loan loan) {
        loanStorage.create(loan);

        return loan;
    }
}
