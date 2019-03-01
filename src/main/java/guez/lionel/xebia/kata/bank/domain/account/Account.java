package guez.lionel.xebia.kata.bank.domain.account;

import java.util.Date;
import java.util.List;

import static guez.lionel.xebia.kata.bank.domain.account.OperationType.DEPOSIT;
import static guez.lionel.xebia.kata.bank.domain.account.OperationType.WITHDRAWAL;

/**
 * Entity representing an account
 */

public class Account {

    private History history;
    private String clientId;

    public Account(String clientId) {
        this.clientId = clientId;
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

    public String getClientId(){
        return clientId;
    }
}
