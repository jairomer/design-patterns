package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockGrabber implements Subject{

    private List<Observer> observers = new ArrayList<>();
    private Map<String,Double> stockPrices = new HashMap<>();

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
        System.out.println("Observer deleted.");
    }

    @Override
    public void notifyObservers() {
        for (Observer obsvr : observers) {
            obsvr.update(stockPrices);
        }
    }

    public void updateStockPrice(String id, Double newValue) {
        this.stockPrices.put(id, newValue);
        notifyObservers();
    }

}
