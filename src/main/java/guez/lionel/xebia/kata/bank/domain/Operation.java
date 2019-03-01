package guez.lionel.xebia.kata.bank.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Value Object representing an Operation in an account
 */
public class Operation {

    private OperationType nature;
    private Date date;
    private double amount;
    private double balance;

    public Operation(OperationType nature, Date date, double amount, double balance) {
        this.nature = nature;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public OperationType getNature() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Double.compare(operation.amount, amount) == 0 &&
                Double.compare(operation.balance, balance) == 0 &&
                nature == operation.nature &&
                Objects.equals(date, operation.date);
    }
}
