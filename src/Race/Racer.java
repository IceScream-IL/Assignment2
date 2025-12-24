package Race;

public class Racer implements Runnable {

    private static int globalId = 1;

    private final int id;
    private final int speed;
    private final Track track;

    public Racer(int speed, Track track) {
        if (speed < 1 || speed > 10) {
            System.out.println("Error: speed must be between 1 and 10");
            this.speed = 1;
        } else {
            this.speed = speed;
        }
        this.track = track;
        this.id = nextId();
    }

    private static synchronized int nextId() {
        return globalId++;
    }

    public void go() {
        Thread.currentThread().setPriority(speed);
        for (int meter = 1; meter <= 100; meter++) {
            System.out.println("Runner " + id + " ran " + meter + " meters");
            if (meter == 100) {
                int place = track.racerFinished();
                System.out.println("Runner " + id + " finished " + ordinal(place));
            }
        }
    }

    @Override
    public void run() {
        go();
    }

    private String ordinal(int n) {
        if (n % 100 >= 11 && n % 100 <= 13) {
            return n + "th";
        }
        switch (n % 10) {
            case 1:
                return n + "st";
            case 2:
                return n + "nd";
            case 3:
                return n + "rd";
            default:
                return n + "th";
        }
    }
}
