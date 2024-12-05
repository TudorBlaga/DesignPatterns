package casino.singleton;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CasinoBalanceTest {
    

    //Verificam implementarea pattern ului Singleton
    @Test
    public void testSingletonInstance() {
        CasinoBalance instance1 = CasinoBalance.getInstance();
        CasinoBalance instance2 = CasinoBalance.getInstance();
        
        boolean areEqual = instance1 == instance2;
        System.out.println("Test Singleton: " + (areEqual ? "CORECT - Ambele instante sunt identice" : 
                                                          "INCORECT - Instantele sunt diferite"));
        assertSame(instance1, instance2);
    }


    //Verificam daca soldul se actualizeaza dupa fiecare operatiune
    @Test
    public void testMoneyOperations() {
        CasinoBalance casino = CasinoBalance.getInstance();
        double initialBalance = casino.getBalance();
        
        casino.addMoney(1000);
        System.out.println("Test Adaugare Bani: " + 
            (casino.getBalance() == initialBalance + 1000 ? 
            "CORECT - Sold actualizat la " + casino.getBalance() : 
            "INCORECT - Sold asteptat: " + (initialBalance + 1000) + ", Sold actual: " + casino.getBalance()));
        
        boolean result = casino.removeMoney(500);
        System.out.println("Test Retragere Bani: " + 
            (casino.getBalance() == initialBalance + 500 ? 
            "CORECT - Sold actualizat la " + casino.getBalance() : 
            "INCORECT - Sold asteptat: " + (initialBalance + 500) + ", Sold actual: " + casino.getBalance()));
        
        assertTrue(result);
        assertEquals(casino.getBalance(), initialBalance + 500);
    }
} 