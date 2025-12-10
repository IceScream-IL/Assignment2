package stocks;

import stocks.StockServer.Stock;

public class Main {
	public static void main(String[] args) {
		StockServer server = new StockServer();
		StockTraders tami = new StockTraders("Tami Tan", server, Stock.GOOGLE);
		StockTraders tim = new StockTraders("Tim Saroli", server, Stock.MICROSOFT);
		StockTraders sima = new StockTraders("Sima Deeds", server, Stock.APPLE);
		
		StockUpdateThread u = new StockUpdateThread(server);
		
		
		Thread t1 = new Thread(tami);
		Thread t2 = new Thread(tim);
		Thread t3 = new Thread(sima);
		
		Thread u1 = new Thread(u);
		
		
		t1.start();
		t2.start();
		t3.start();
		u1.start();
		
	}

}
