package stocks;

import java.util.Random;

public class StockTraders implements Runnable {

	private final String name;
	private final StockServer server;
	private final Random random= new Random();;
	StockServer.Stock one;

	public StockTraders(String name, StockServer server, StockServer.Stock one ) {
		this.name = name;
		this.server = server;
		this.one = one;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				int price = server.GetStock(one);

				System.out.println("Name: " + name + ", " + one + " Stock: " + price + " USD");

				Thread.sleep((random.nextInt(3) + 1) * 1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
