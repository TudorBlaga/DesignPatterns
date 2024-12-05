package casino.singleton;

public class CasinoBalance {
    private static CasinoBalance instance;
    private double balance;

    private CasinoBalance() {
        balance = 1000000.0; // Initial casino balance
    }

    public static synchronized CasinoBalance getInstance() {
        if (instance == null) {
            instance = new CasinoBalance();
        }
        return instance;
    }

    public synchronized void addMoney(double amount) {
        this.balance += amount;
    }

    public synchronized boolean removeMoney(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
} 