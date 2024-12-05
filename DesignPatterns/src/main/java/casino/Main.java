package casino;

import casino.factory.*;
import casino.observer.*;
import casino.singleton.*;
import casino.strategy.*;

public class Main {
    public static void main(String[] args) {
        // initializam balanta casionoului(Singleton)
        CasinoBalance casino = CasinoBalance.getInstance();
        System.out.println("=== CAZINOU DESCHIS ===");
        System.out.println("Sold initial: " + casino.getBalance() + " RON\n");

        // creeam strategiile de pariere
        BettingStrategy martingaleStrategy = new MartingaleStrategy();
        BettingStrategy conservativeStrategy = new ConservativeStrategy();

        // facem factory ul pentru jocuri si observatori
        GameFactory gameFactory = new GameFactory();
        GameSubject gameSubject = new GameSubject();
        
        // creeam jucatori cu diferite straegii
        Player player1 = new Player("Ion (cu strategia Martingale)");
        Player player2 = new Player("Maria (cu strategia Conservative)");
        
        // abonam jucatorii la notificri
        gameSubject.attach(player1);
        gameSubject.attach(player2);

        // simulam niste joburi
        System.out.println("=== INCEPEM JOCURILE ===");
        
        // simulam slots
        Game slots = gameFactory.createGame("slots");
        playGame(slots, player1, martingaleStrategy, 3, casino, gameSubject);
        
        System.out.println("\n=== SCHIMBARE JOC ===\n");
        
        // simulam ruleta
        Game roulette = gameFactory.createGame("roulette");
        playGame(roulette, player2, conservativeStrategy, 3, casino, gameSubject);
        
        System.out.println("\n=== CAZINOU INCHIS ===");
        System.out.println("Sold final: " + casino.getBalance() + " RON");
    }
    
    private static void playGame(Game game, Player player, BettingStrategy strategy, 
                               int rounds, CasinoBalance casino, GameSubject gameSubject) {
        int consecutiveLosses = 0;
        
        for (int i = 1; i <= rounds; i++) {
            System.out.println("\nRunda " + i + ":");
            double currentBet = strategy.calculateBet(casino.getBalance(), consecutiveLosses);
            System.out.println("Pariu: " + currentBet + " RON");
            
            String result = game.play();
            if (result.equals("WIN")) {
                double winnings = game.calculatePayout(currentBet);
                casino.removeMoney(winnings);
                System.out.println("Castig: " + winnings + " RON");
                consecutiveLosses = 0;
                gameSubject.notifyObservers(player.toString() + " a castigat " + winnings + " RON!");
            } else {
                casino.addMoney(currentBet);
                System.out.println("Pierdere: " + currentBet + " RON");
                consecutiveLosses++;
                gameSubject.notifyObservers(player.toString() + " a pierdut " + currentBet + " RON");
            }
            
            System.out.println("Sold cazinou: " + casino.getBalance() + " RON");
        }
    }
} 