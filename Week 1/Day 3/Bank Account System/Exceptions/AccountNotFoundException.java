package Exceptions;

public class AccountNotFoundException extends BankException{
    public AccountNotFoundException(String message){
        super("The following account number: " + message + " does not exist");
    }
}
