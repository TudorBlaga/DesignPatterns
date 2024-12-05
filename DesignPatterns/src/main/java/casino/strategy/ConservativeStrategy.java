package casino.strategy;

public class ConservativeStrategy implements BettingStrategy {
    @Override
    public double calculateBet(double currentBalance, int consecutiveLosses) {
        return Math.min(currentBalance * 0.1, 100.0);
    }
} 