package guez.lionel.xebia.kata.bank.domain.account;

import guez.lionel.xebia.kata.bank.domain.exception.NegativeAmountException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Entity representing the history of an account
 */

public class History {

    private List<Operation> operations;

    public History() {
        this.operations = new ArrayList<>();
    }

    public double getLastBalance() {
        if (operations.isEmpty()) {
            return 0;
        }
        return operations.get(operations.size() - 1).getBalance();
    }

    public void addOperation(OperationType operationType, Date date, double amount) {
        checkAmount(amount);
        double balance = getLastBalance();
        switch (operationType) {
            case DEPOSIT:
                balance += amount;
                break;
            case WITHDRAWAL:
                balance -= amount;
                break;
        }
        operations.add(new Operation(operationType, date, amount, balance));
    }

    private void checkAmount(double amount) {
        if(amount < 0){
            throw new NegativeAmountException();
        }
    }

    public List<Operation> getOperations() {
        return Collections.unmodifiableList(operations);
    }

}