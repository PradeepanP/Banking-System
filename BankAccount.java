package BankSystem;

import java.util.ArrayList;
import java.util.List;

abstract class BankAccount implements AccountOperations {
    protected String accountHolder;
    protected double balance;
    private List<Transaction> transactionHistory;
    
    public BankAccount(String accountHolder, double balance){
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }
    public synchronized void deposit(double amount){
        balance += amount;
        transactionHistory.add(new Transaction(accountHolder,amount));
        System.out.println(amount + " deposited and balance is " + balance);
    }
    public void withDraw(double amount) throws InsufficientFundsException{
        if(balance >= amount){
            balance -= amount;
            transactionHistory.add(new Transaction(accountHolder, amount));
            System.out.println(amount + " withdrawn . New Balance :" + balance);
        }else{
            throw new InsufficientFundsException("Insufficent fund " + balance);
        }
    }
    public void displayBalance(){
        System.out.println("Balance " + accountHolder + " : " + balance);
    }
    public void displayTransactionHistory(){
        System.out.println("Transaction History for " + accountHolder + ":");
        for(Transaction t : transactionHistory){
            System.out.println(t);
        }
    }
    public abstract void applyInterest();
}
