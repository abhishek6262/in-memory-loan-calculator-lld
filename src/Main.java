import Entities.Admin;
import Entities.Customer;
import Entities.Emi;
import Entities.Loan;
import Services.EmiService;
import Services.LoanService;
import Services.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        LoanService loanService = new LoanService();
        EmiService emiService = new EmiService();

        Admin admin = userService.createAdmin("abhishek", "Abhishek Prakash");
        Customer customer = userService.createCustomer("raj", "Raj Colaco");

        Loan loan = loanService.createLoan(
                admin.username,
                customer.username,
                10000F,
                10.5F,
                24
        );

        emiService.payEmi(customer.username, loan);
        emiService.payEmi(customer.username, loan);
        emiService.payEmi(customer.username, loan);

        List<Emi> totalEmis = emiService.getLoanAllEmis(admin.username, loan);
        List<Emi> paidEmis = emiService.getLoanPaidEmis(admin.username, loan);
        List<Emi> unpaidEmis = emiService.getLoanUnpaidEmis(admin.username, loan);

        System.out.println(totalEmis);
        System.out.println(paidEmis);
        System.out.println(unpaidEmis);
    }
}