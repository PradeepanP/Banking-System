package BankSystem;

abstract class BankAccount implements AccountOperations {
    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountHolder, double balance){
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public synchronized void deposit(double amount){
        balance += amount;
        System.out.println(amount + " deposited and balance is " + balance);
    }
    public void displayBalance(){
        System.out.println("Balance " + accountHolder + " : " + balance);
    }
    public abstract void withDraw(double amount) throws InsufficientFundsException;
}
