import Exceptions.AccountNotFoundException;
import Exceptions.BankException;
import Exceptions.InsufficientFundsException;
import Exceptions.InvalidAmountException;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();
    private int nextId = 1000;
    public Account openAccount(String owner, double initialAmount){
        String accountNumber = "ACC-" + (++nextId);
        Account account = new Account(accountNumber, owner, initialAmount);
        accounts.put(accountNumber, account);
        System.out.println("Opening account " + account.getAccountNumber() + " with owner " + account.getOwner());
        return account;
    }

    public Account getAccount(String accountNumber) throws AccountNotFoundException {
        if(!accounts.containsKey(accountNumber)){
            throw new AccountNotFoundException(accountNumber);
        }
        return accounts.get(accountNumber);
    }

    public void transfer(String from, String to, double amount) throws BankException {
        Account fromAccount = getAccount(from);
        Account toAccount = getAccount(to);

        fromAccount.withdraw(amount);
        try {
            toAccount.deposit(amount);
        }catch (InvalidAmountException e){
            fromAccount.deposit(amount);
            throw new BankException("Transfer failed, rolled back: " + e.getMessage());
        }
    }
}
