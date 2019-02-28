package guez.lionel.xebia.kata.bank.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class History {

    private double lastBalance;
    private List<Operation> operations;

    public History() {
        this.lastBalance = 0;
        this.operations = new ArrayList<>();
    }

    public double getLastBalance() {
        return lastBalance;
    }

    public void addOperation(OperationNature operationNature, Date date, double amount){
        switch (operationNature){
            case DEPOSIT:
                lastBalance += amount;
                break;
            case WITHDRAWAL:
                lastBalance -= amount;
                break;
        }
        operations.add(new Operation(operationNature,date,amount,lastBalance));
    }

    public List<Operation> getOperations(){
        return Collections.unmodifiableList(operations);
    }

}
