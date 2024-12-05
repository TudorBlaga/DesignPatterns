package casino.strategy;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class BettingStrategyTest {
    

    //Verificam daca pariul se dubleaza dupa fiecare pierdere(model Martingale)
    @Test
    public void testMartingaleStrategy() {
        BettingStrategy strategy = new MartingaleStrategy();
        double bet = strategy.calculateBet(1000, 2);
        double expectedBet = 40.0; // 10 * 2^2
        
        System.out.println("Test Martingale: " + 
            (Math.abs(bet - expectedBet) < 0.01 ? 
            "CORECT - Pariu calculat: " + bet : 
            "INCORECT - Pariu asteptat: " + expectedBet + ", Pariu calculat: " + bet));
        
        assertEquals(40.0, bet, 0.01);
    }


    //Verificam daca pariul ramane in limitele stabilie(10% din sold, maxim 100)
    @Test
    public void testConservativeStrategy() {
        BettingStrategy strategy = new ConservativeStrategy();
        double bet = strategy.calculateBet(1000, 5);
        
        System.out.println("Test Conservator: " + 
            (Math.abs(bet - 100.0) < 0.01 ? 
            "CORECT - Pariu limitat la " + bet : 
            "INCORECT - Pariu astetat: 100.0, Pariu calculat: " + bet));
        
        assertEquals(100.0, bet, 0.01);
    }
} 