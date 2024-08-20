package Storage;

import Entities.Emi;
import Entities.Loan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmiStorage {
    private static EmiStorage instance;

    Map<Loan, List<Emi>> emis = new HashMap<>();

    private EmiStorage() {}

    public void create(Loan loan, Emi emi) {
        List<Emi> loanEmis = emis.computeIfAbsent(loan, k -> new ArrayList<>());

        loanEmis.add(emi);
    }

    public List<Emi> getLoanEmis(Loan loan) {
        return emis.computeIfAbsent(loan, k -> new ArrayList<>());
    }

    public static EmiStorage getInstance() {
        if (instance == null) {
            instance = new EmiStorage();
        }

        return instance;
    }
}
