package casino.strategy;

public interface BettingStrategy {
    double calculateBet(double currentBalance, int consecutiveLosses);
} 