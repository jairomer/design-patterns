package observer;

import java.util.HashMap;
import java.util.Map;

public class StockObserver implements Observer {

    private Map<String, Double> stocks = new HashMap<>();

    private static int observerIdTracker = 0;
    private final int observerID;

    private Subject stockGrabber;

    public StockObserver(Subject stockGrabber) {
        this.stockGrabber = stockGrabber;
        this.observerID = ++observerIdTracker;
        System.out.println("New observer "+this.observerID);
        this.stockGrabber.register(this);
    }

    @Override
    public void update(Map<String, Double> newStocks) {
        System.out.println("Update observer "+ observerID);
        for (Map.Entry<String, Double> stock : newStocks.entrySet()) {
            stocks.put(stock.getKey(), stock.getValue());
            System.out.printf("New price: %s -> %s %n", stock.getKey(), stock.getValue().toString());
        }
    }
}
