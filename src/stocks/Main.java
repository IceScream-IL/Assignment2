package stocks;

public class Main {
	public static void main(String[] args) {
		StockServer server = new StockServer();
		StockTraders tami = new StockTraders("Tami Tan", server);
		StockTraders tim = new StockTraders("Tim Saroli", server);
		StockTraders sima = new StockTraders("Sima Deeds", server);
		
		Thread t1 = new Thread(tami);
		Thread t2 = new Thread(tim);
		Thread t3 = new Thread(sima);
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
