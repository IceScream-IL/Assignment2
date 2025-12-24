package stocks;

import java.util.concurrent.ThreadLocalRandom;

public class StockTraders extends Thread {

    private final String personName;
    private final StockServer server;
    private final StockServer.Stock stock;

    public StockTraders(String personName, StockServer server, StockServer.Stock stock) {
        this.personName = personName;
        this.server = server;
        this.stock = stock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = server.GetStock(stock);
            System.out.println("Name: " + personName + ", " + stockName(stock) + " Stock: " + value + " USD");
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3001));
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private String stockName(StockServer.Stock s) {
        switch (s) {
            case MICROSOFT:
                return "Microsoft";
            case APPLE:
                return "Apple";
            case GOOGLE:
                return "Google";
            default:
                return s.name();
        }
    }
}
