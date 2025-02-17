package BankSystem;

public class SavingsAccount extends BankAccount{
    private static final double MIN_BALANCE = 5000;

    public SavingsAccount(String accountHolder, double balance){
        super(accountHolder, balance);
    }
    @Override
    public synchronized void withDraw(double amount) throws InsufficientFundsException{
        if(balance - amount < MIN_BALANCE){
            throw new InsufficientFundsException("Insufficient funds " + balance);
        }
        balance -= amount;
        System.out.println(amount + " withdrawn. New Balance :" + balance);
    }
}
