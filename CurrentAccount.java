package BankSystem;

public class CurrentAccount extends BankAccount{
    private static final double OVERDRAFT_LIMIT = 5000.0;

    public CurrentAccount(String accountHolder, double balance){
        super(accountHolder, balance);
    }
    @Override
    public synchronized void withDraw(double amount) throws InsufficientFundsException{
        if(balance - amount < -OVERDRAFT_LIMIT){
            throw new InsufficientFundsException("overdraft limit exceeded " + balance);
        }
        balance -= amount;
        System.out.println(amount + " withdrawn. New balance " + balance);
    }
    @Override
    public void applyInterest() {
        // Current accounts typically don't apply interest, so this can be empty or not applicable
        System.out.println("No interest for Current Account.");
    }
}
