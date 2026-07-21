import Demo.Vault;
import Exceptions.AccountNotFoundException;
import Exceptions.BankException;
import Exceptions.InsufficientFundsException;
import Exceptions.InvalidAmountException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        try (Vault v = new Vault()) {
            System.out.println("Inside the try - using the vault");
        }

        System.out.println("Welcome to our Bank Account System");
        boolean exit = false;
        while(!exit){
            System.out.println("------------------------");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer to Account");
            System.out.println("5. View balance");
            System.out.println("6. Exit");
            System.out.println("------------------------");
            int choice = 0;
            try{
                System.out.print("Enter your choice: ");
                choice = input.nextInt();
                input.nextLine();
            }catch(InputMismatchException e){
                System.out.println("Please enter a valid choice");
                input.nextLine();
            }
            switch (choice){
                case 1:
                    try{
                        System.out.print("Enter Account Name: ");
                        String name = input.nextLine();
                        System.out.print("Enter initial balance: ");
                        double initialBalance = input.nextDouble();
                        input.nextLine();
                        bank.openAccount(name, initialBalance);
                    }catch(InputMismatchException e){
                        System.out.println("Please enter a valid initial balance");
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Enter Account Number: ");
                        String accountNumber = input.nextLine();
                        System.out.print("Enter amount to deposit: ");
                        double amount = input.nextDouble();
                        input.nextLine();
                        Account currentAccount = bank.getAccount(accountNumber);
                        currentAccount.deposit(amount);
                        System.out.println("Deposited " + amount + " to " + currentAccount.getAccountNumber());
                    }catch(AccountNotFoundException e){
                        System.out.println("Account not found");
                    }catch(InvalidAmountException e){
                        System.out.println("Invalid amount");
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Enter Account Number: ");
                        String accountNumber2 = input.nextLine();
                        System.out.print("Enter amount to withdraw: ");
                        double amount2 = input.nextDouble();
                        input.nextLine();
                        Account currentAccount2 = bank.getAccount(accountNumber2);
                        currentAccount2.withdraw(amount2);
                    }catch(AccountNotFoundException e){
                        System.out.println(e.getMessage());
                    }catch(InvalidAmountException e){
                        System.out.println("Invalid amount");
                    }catch(InsufficientFundsException e){
                        System.out.printf("Declined. You have %.2f but tried to withdraw %.2f .%n", e.getBalance(),
                                e.getRequested());
                    }
                    break;

                case 4:
                    try{
                        System.out.print("Enter Account Number: ");
                        String fromAccountNumber = input.nextLine();
                        System.out.print("Enter amount to transfer: ");
                        double amountToTransfer = input.nextDouble();
                        input.nextLine();
                        System.out.println("Enter Account Number to transfer: ");
                        String toAccountNumber = input.nextLine();
                        bank.transfer(fromAccountNumber, toAccountNumber, amountToTransfer);
                        System.out.println("Transferring " + fromAccountNumber + " to " + toAccountNumber);
                        System.out.println("Transfer completed");
                        System.out.println("Your account balance is " + bank.getAccount(fromAccountNumber).getBalance());
                    } catch (BankException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try{
                        System.out.println("Enter Account Number: ");
                        String viewBalanceAccountNumber = input.nextLine();
                        System.out.println("Current balance: " + bank.getAccount(viewBalanceAccountNumber).getBalance());
                    }catch(AccountNotFoundException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 6:
                    demo();
                    exit = true;
                    break;
            }
        }
    }

    static int demo(){
        try{
            System.out.println("in try");
            return 1;
        }finally {
            System.out.println("finally runs BEFORE the method actually returns");
        }
    }
}
