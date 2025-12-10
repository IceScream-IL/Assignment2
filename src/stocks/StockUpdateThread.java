package stocks;

import java.util.Random;

import stocks.StockServer.Stock;

public class StockUpdateThread implements Runnable {
	
	private final StockServer server;
	private final Random random = new Random();
	
	public StockUpdateThread(StockServer server) {
		this.server = server;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {

				server.UpdateStock(Stock.APPLE, random.nextInt(100,501));
				server.UpdateStock(Stock.MICROSOFT, random.nextInt(100,501));
				server.UpdateStock(Stock.GOOGLE, random.nextInt(100,501));

				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
