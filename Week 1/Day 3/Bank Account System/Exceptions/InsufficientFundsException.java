package Exceptions;

public class InsufficientFundsException extends BankException{

    private double balance;
    private double requested;

    public InsufficientFundsException(double balance, double requested) {
        super("Insufficient Funds: balance %.2f, requested %.2f".formatted(balance, requested));
        this.balance = balance;
        this.requested = requested;
    }

    public double getBalance() {
        return balance;
    }
    public double getRequested() {
        return requested;
    }
}
