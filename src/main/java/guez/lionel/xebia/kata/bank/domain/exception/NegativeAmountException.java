package guez.lionel.xebia.kata.bank.domain.exception;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException() {
        super("You cannot add withdraw or deposit a negative amount");
    }
}
