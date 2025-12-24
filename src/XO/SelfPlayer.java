package XO;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SelfPlayer extends Player {

    public SelfPlayer(PlayerType type, Game game) {
        super(type, game);
    }

    @Override
    public void run() {
        while (!game.isGameOver()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }

            if (game.isGameOver()) return;
            if (game.getTurn() != type) continue;

            List<Cell> free = game.getFreeCells();
            if (free.isEmpty()) {
                System.out.println("full is Board");
                return;
            }

            Cell chosen = free.get(ThreadLocalRandom.current().nextInt(free.size()));
            boolean moved = attempt(chosen.getRow(), chosen.getCol());
            if (moved) {
                game.printBoard();
            }
        }
    }

    private boolean attempt(int r, int c) {
        return game.makeMove(type, r, c);
    }
}
