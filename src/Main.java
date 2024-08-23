import Entities.Admin;
import Entities.Customer;
import Entities.Loan;
import Services.LoanService;
import Services.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        LoanService loanService = new LoanService();

        Admin admin = userService.createAdmin("abhishek", "Abhishek Prakash");
        Customer customer = userService.createCustomer("raj", "Raj Colaco");

        Loan loan = loanService.createLoan(
                admin.username,
                customer.username,
                10000F,
                10.5F,
                24
        );

        System.out.println("Total Amount: " + loan.getTotalAmount());
    }
}