package Exceptions;

public class InvalidAmountException extends BankException{
    public InvalidAmountException(String errorMessage) {
        super(errorMessage);
    }
}
