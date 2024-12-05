package casino.observer;

import org.junit.Test;

public class GameObserverTest {


    //Verificam notificarile jucatorilor din pattern ul Observer
    @Test
    public void testObserverPattern() {
        GameSubject gameSubject = new GameSubject();
        Player player1 = new Player("Jucatorul nr. 1");
        Player player2 = new Player("Jucatorul nr. 2");
        
        // Atasam observatorii (jucatorii)
        gameSubject.attach(player1);
        gameSubject.attach(player2);
        System.out.println("Test Atasare Observatori: CORECT - Doi jucatori atasati");
        
        // Trimitem o notificare catre toti jucatorii
        System.out.println("\nTest Notificare Initiala:");
        gameSubject.notifyObservers("Jackpot!");
        
        // Detasam un jucator si verificam daca mai primeste notificari
        gameSubject.detach(player2);
        System.out.println("\nTest Notificare dupa Detasare:");
        gameSubject.notifyObservers("Game Over");
    }
} 