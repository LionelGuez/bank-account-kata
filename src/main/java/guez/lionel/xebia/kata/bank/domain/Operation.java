package guez.lionel.xebia.kata.bank.domain;

import java.util.Date;

public class Operation {

    private OperationNature nature;
    private Date date;
    private double amount;
    private double balance;

    public Operation(OperationNature nature, Date date, double amount, double balance) {
        this.nature = nature;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public OperationNature getNature() {
        return nature;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }
}
