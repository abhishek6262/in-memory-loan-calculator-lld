package Repositories;

import Entities.Emi;
import Entities.Loan;
import Storage.EmiStorage;

import java.util.List;

public class EmiRepository {
    private final EmiStorage emiStorage = EmiStorage.getInstance();

    public List<Emi> getByLoan(Loan loan) {
        return emiStorage.getLoanEmis(loan);
    }

    public void registerEmisForLoan(Loan loan) {
        for (int i = 0; i < loan.tenureInMonths; i++) {
            emiStorage.create(loan, new Emi());
        }
    }
}
