package casino.factory;

import java.util.Random;

public class SlotMachine implements Game {
    private Random random = new Random();

    @Override
    public String play() {
        int result = random.nextInt(100);
        return result < 30 ? "WIN" : "LOSE";
    }

    @Override
    public double calculatePayout(double bet) {
        return bet * 2;
    }
} 