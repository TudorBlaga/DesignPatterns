package casino.factory;

import java.util.Random;

public class Roulette implements Game {
    private Random random = new Random();

    @Override
    public String play() {
        int result = random.nextInt(37);
        return result == 0 ? "WIN" : "LOSE";
    }

    @Override
    public double calculatePayout(double bet) {
        return bet * 35;
    }
} 