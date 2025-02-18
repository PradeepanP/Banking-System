package BankSystem;

import java.io.FileWriter;
import java.io.IOException;

public class SavingsAccount extends BankAccount{
    private static final double INTEREST_RATE = 0.05;

    public SavingsAccount(String accountHolder, double balance){
        super(accountHolder, balance);
    }
    @Override
    public void applyInterest() {
        double interest = balance * (INTEREST_RATE / 12); // Monthly interest
        deposit(interest);
        System.out.println("Interest of $" + interest + " applied.");
    }
    public void saveTransactionToFile(String transaction) {
    try (FileWriter writer = new FileWriter("transactions.txt", true)) {
        writer.write(transaction + "\n");
    } catch (IOException e) {
        System.out.println("Error writing to file.");
    }
}
}
