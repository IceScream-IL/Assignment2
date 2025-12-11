package Race;

public class Racer implements Runnable {
	private static int globalId = 1;
	private final int id;
	private final int speed;
	private final Track track;

	public Racer(int speed, Track track) {
		if (speed < 1 || speed > 10) {
			throw new IllegalArgumentException("Speed must be between 1 and 10");
		}

		this.id = globalId++;
		this.speed = speed;
		this.track = track;
	}

	public void go() {
	    Thread.currentThread().setPriority(speed);

	    for (int i = 1; i <= 100; i++) {
	        System.out.println("Runner " + id + " ran " + i + " meters");

	        if (i == 100) {
	            synchronized (track) { // כל הקטע של המקום נעול על אותו Track
	                int place = track.getFinishedRacers();

	                if (place == 1) {
	                    System.out.println("Runner " + id + " finished " + place + "st");
	                } else if (place == 2) {
	                    System.out.println("Runner " + id + " finished " + place + "nd");
	                } else if (place == 3) {
	                    System.out.println("Runner " + id + " finished " + place + "rd");
	                } else {
	                    System.out.println("Runner " + id + " finished " + place + "th");
	                }

	                // מעלה את המקום לרץ הבא
	                track.setFinishedRacers(place + 1);
	            }
	        }
	    }
	}

	@Override
	public void run() {
		go();
	}
}
