package casino.observer;

public class Player implements GameObserver {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void update(String gameResult) {
        System.out.println(name + " a primit update: " + gameResult);
    }
} 