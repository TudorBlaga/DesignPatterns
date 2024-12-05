package casino.strategy;

public class MartingaleStrategy implements BettingStrategy {
    @Override
    public double calculateBet(double currentBalance, int consecutiveLosses) {
        double baseBet = 10.0;
        return Math.min(baseBet * Math.pow(2, consecutiveLosses), currentBalance);
    }
} 