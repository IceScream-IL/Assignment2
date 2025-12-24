package Race;

import java.util.concurrent.atomic.AtomicInteger;

public class Track {

    private final AtomicInteger finishedRacers = new AtomicInteger(0);

    public int racerFinished() {
        return finishedRacers.incrementAndGet();
    }

    public int getFinishedRacers() {
        return finishedRacers.get();
    }
}
