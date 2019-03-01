package guez.lionel.xebia.kata.bank.domain;

import java.util.Date;
import java.util.List;

import static guez.lionel.xebia.kata.bank.domain.OperationType.DEPOSIT;
import static guez.lionel.xebia.kata.bank.domain.OperationType.WITHDRAWAL;

/**
 * Entity representing an account
 */

public class Account {

    private History history;

    public Account() {
        history = new History();
    }

    public void deposit(double amount) {
        deposit(amount,new Date());
    }

    public void withdraw(double amount) {
        withdraw(amount,new Date());
    }

    public double getBalance() {
        return history.getLastBalance();
    }

    public void deposit(double amount, Date date) {
        history.addOperation(DEPOSIT,date,amount);
    }

    public void withdraw(double amount, Date date) {
        history.addOperation(WITHDRAWAL,date,amount);
    }

    public List<Operation> getOperations() {
        return history.getOperations();
    }
}
