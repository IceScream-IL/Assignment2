package stocks;

public class StockUpdateThread extends Thread {

    private final StockServer server;

    public StockUpdateThread(StockServer server) {
        this.server = server;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            server.UpdateStock(StockServer.Stock.MICROSOFT, 0);
            server.UpdateStock(StockServer.Stock.APPLE, 0);
            server.UpdateStock(StockServer.Stock.GOOGLE, 0);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
