package guez.lionel.xebia.kata.bank.domain;

public class Account {

    double balance;

    public Account(){
        balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
