package guez.lionel.xebia.kata.bank.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import static guez.lionel.xebia.kata.bank.domain.OperationNature.DEPOSIT;
import static guez.lionel.xebia.kata.bank.domain.OperationNature.WITHDRAWAL;

public class Account {

    private List<Operation> history;

    public Account() {
        history = new ArrayList<>();
    }

    public void deposit(double amount) {
        deposit(amount,new Date());
    }

    public void withdraw(double amount) {
        withdraw(amount,new Date());
    }

    public double getBalance() {
        if(history.isEmpty()){
            return 0;
        }
        return history.get(history.size() - 1).getBalance();
    }

    public void deposit(double amount, Date date) {
        double newBalance = getBalance() + amount;
        history.add(new Operation(DEPOSIT,date,amount,newBalance));
    }

    public void withdraw(double amount, Date date) {
        double newBalance = getBalance() - amount;
        history.add(new Operation(WITHDRAWAL,date,amount,newBalance));
    }

    public List<Operation> getHistory() {
        return history;
    }
}
