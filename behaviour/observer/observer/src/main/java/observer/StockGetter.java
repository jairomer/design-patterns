package observer;

public class StockGetter {

    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();

        StockObserver observer1 = new StockObserver(stockGrabber);
        StockObserver observer2 = new StockObserver(stockGrabber);

        stockGrabber.updateStockPrice("ibm", 23.3);
        stockGrabber.updateStockPrice("appl", 342.23);
        stockGrabber.updateStockPrice("gool", 1223.34);

        stockGrabber.unregister(observer1);

        stockGrabber.updateStockPrice("gool", -12.2);
    }
}

