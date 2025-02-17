package BankSystem;

public class Main {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("Steph",100000);
        BankAccount current = new CurrentAccount("Michael", 500000);
        
        Thread t1 = new Thread(() -> {
            savings.deposit(20000);
            try {
                savings.withDraw(100000);
            } catch (InsufficientFundsException e) {
                System.out.println(Thread.currentThread().getName() + "Error : " + e.getMessage());
            }
        }, "user-1 ");

        Thread t2 = new Thread(() -> {
            current.deposit(25000);
            try {
                current.withDraw(50000);
            } catch (InsufficientFundsException e) {
                System.out.println(Thread.currentThread().getName() + "Error : " + e.getMessage());
            }
        }, "user-2 ");

        t1.start();
        t2.start();
    }
}
