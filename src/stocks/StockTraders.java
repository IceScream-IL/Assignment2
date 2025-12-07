package stocks;

import java.util.Random;

public class StockTraders implements Runnable {

	private String name;
	private StockServer server;
	private Random random;

	public StockTraders(String name, StockServer server) {
		this.name = name;
		this.server = server;
		this.random = new Random();
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				StockServer.Stock[] stocks = StockServer.Stock.values();
				StockServer.Stock randomStock = stocks[random.nextInt(stocks.length)];

				int price = server.GetStock(randomStock);

				System.out.println("Name: " + name + ", " + randomStock + " Stock: " + price + " USD");

				Thread.sleep((random.nextInt(3) + 1) * 1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
