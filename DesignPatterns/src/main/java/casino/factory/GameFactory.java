package casino.factory;

public class GameFactory {
    public Game createGame(String gameType) {
        switch (gameType.toLowerCase()) {
            case "slots":
                return new SlotMachine();
            case "roulette":
                return new Roulette();
            default:
                throw new IllegalArgumentException("Unknown game type: " + gameType);
        }
    }
} 