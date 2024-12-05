package casino.factory;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameFactoryTest {


    // verificam ca se creeaza corect tipurile de joc cu Factory Pattern
    @Test
    public void testGameFactory() {
        GameFactory factory = new GameFactory();
        
        // Verificam ca se creeaza corect un joc de tip slot machine
        Game slots = factory.createGame("slots");
        System.out.println("Test Creare Slot Machine: " + 
            (slots instanceof SlotMachine ? 
            "CORECT - Instanta creata corect" : 
            "INCORECT - Tip incorect de joc creat"));
        
        // Verificam ca se creeaza corect joc de tip ruleta
        Game roulette = factory.createGame("roulette");
        System.out.println("Test Creare Ruleta: " + 
            (roulette instanceof Roulette ? 
            "CORECT - Instanta creata corect" : 
            "INCORECT - Tip incorect de joc creat"));
        
        assertTrue(slots instanceof SlotMachine);
        assertTrue(roulette instanceof Roulette);
    }


   //Verificam ca se atunca un IllegalArgumentException pentru un tip de joc invalid
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidGameType() {
        GameFactory factory = new GameFactory();
        try {
            factory.createGame("invalid");
            System.out.println("Test Joc Invalid: INCORECT - Nu s-a aruncat exceptia asteptata");
        } catch (IllegalArgumentException e) {
            System.out.println("Test Joc Invalid: CORECT - Exceptie aruncata pentru tip invalid de joc");
            throw e;
        }
    }
} 