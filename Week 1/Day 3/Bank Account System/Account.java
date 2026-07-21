import Exceptions.InsufficientFundsException;
import Exceptions.InvalidAmountException;

public class Account {

    private final String accountNumber;
    private final String owner;
    private double balance;

    public Account(String accountNumber, String owner, double balance){
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public String getOwner(){
        return this.owner;
    }

    public double getBalance(){
        return this.balance;
    }

    public void deposit(double amount) throws InvalidAmountException{

        if(amount <= 0){
            throw new InvalidAmountException("You cannot enter a negative amount!");
        }else{
            this.balance += amount;
        }
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if(amount <= 0){
            throw new InvalidAmountException("You cannot withdraw a negative amount!");
        }else if (amount > getBalance()){
            throw new InsufficientFundsException(getBalance(), amount);
        }else{
            this.balance -= amount;
        }
    }

    @Override
    public String toString(){
        return "Account Number: " + getAccountNumber() + " Owner: " + getOwner() + " Balance: " + getBalance();
    }
}
