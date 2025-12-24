package stocks;

public class Main {

    public static void main(String[] args) {
        StockServer server = new StockServer();

        Thread t1 = new StockTraders("Tami Tan", server, StockServer.Stock.MICROSOFT);
        Thread t2 = new StockTraders("Tim Seroly", server, StockServer.Stock.APPLE);
        Thread t3 = new StockTraders("Sima Dids", server, StockServer.Stock.GOOGLE);

        Thread updater = new StockUpdateThread(server);

        t1.start();
        t2.start();
        t3.start();
        updater.start();
    }
}
