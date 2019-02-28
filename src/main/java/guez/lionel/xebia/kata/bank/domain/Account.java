package guez.lionel.xebia.kata.bank.domain;

import java.util.ArrayList;
import java.util.Date;

import static guez.lionel.xebia.kata.bank.domain.OperationNature.DEPOSIT;
import static guez.lionel.xebia.kata.bank.domain.OperationNature.WITHDRAWAL;

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

    public History getHistory() {
        return history;
    }
}
