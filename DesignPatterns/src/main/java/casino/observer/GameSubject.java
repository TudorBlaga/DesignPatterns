package casino.observer;

import java.util.ArrayList;
import java.util.List;

public class GameSubject {
    private List<GameObserver> observers = new ArrayList<>();

    public void attach(GameObserver observer) {
        observers.add(observer);
    }

    public void detach(GameObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String gameResult) {
        for (GameObserver observer : observers) {
            observer.update(gameResult);
        }
    }
} 