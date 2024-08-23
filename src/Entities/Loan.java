package Entities;

public class Loan {
    public Admin admin;

    public Customer customer;

    public Float principal;

    public Float interestRate;

    public Integer tenureInMonths;

    public Loan(Admin admin, Customer customer, Float principal, Float interestRate, Integer tenureInMonths) {
        this.admin = admin;
        this.customer = customer;
        this.principal = principal;
        this.interestRate = interestRate;
        this.tenureInMonths = tenureInMonths;
    }

    public Float getTotalInterest() {
        return (principal * interestRate * (tenureInMonths / 12)) / 100;
    }

    public Float getTotalAmount() {
        return principal + getTotalInterest();
    }
}
