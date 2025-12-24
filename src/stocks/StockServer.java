package stocks;

import java.security.InvalidParameterException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class StockServer {

    private final AtomicInteger microsoftValue = new AtomicInteger(220);
    private final AtomicInteger appleValue = new AtomicInteger(110);
    private final AtomicInteger googleValue = new AtomicInteger(1512);

    public enum Stock {
        MICROSOFT,
        APPLE,
        GOOGLE
    }

    public int GetStock(Stock stock) {
        switch (stock) {
            case MICROSOFT:
                return microsoftValue.get();
            case APPLE:
                return appleValue.get();
            case GOOGLE:
                return googleValue.get();
            default:
                throw new InvalidParameterException("no such stock type");
        }
    }

    public void UpdateStock(Stock stock, int value) {
        int v = ThreadLocalRandom.current().nextInt(100, 501);
        switch (stock) {
            case MICROSOFT:
                microsoftValue.set(v);
                return;
            case APPLE:
                appleValue.set(v);
                return;
            case GOOGLE:
                googleValue.set(v);
                return;
            default:
                throw new InvalidParameterException("no such stock type");
        }
    }
}
