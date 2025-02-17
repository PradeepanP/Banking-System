package BankSystem;

public interface AccountOperations {
    void deposit(double amount);
    void withDraw(double amount) throws InsufficientFundsException;
    void displayBalance();
}
