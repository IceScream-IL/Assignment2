package XO;

import java.util.Scanner;

public class UserPlayer extends Player {

    private final Scanner scanner;

    public UserPlayer(PlayerType type, Game game, Scanner scanner) {
        super(type, game);
        this.scanner = scanner;
    }

    @Override
    public void run() {
        while (!game.isGameOver()) {
            if (game.isGameOver()) return;
            if (game.getTurn() != type) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    return;
                }
                continue;
            }

            System.out.println("Enter row and col (0-4):");
            int r;
            int c;
            try {
                r = scanner.nextInt();
                c = scanner.nextInt();
            } catch (Exception e) {
                return;
            }

            boolean moved = attempt(r, c);
            if (moved) {
                game.printBoard();
            } else {
                System.out.println("Invalid move");
            }
        }
    }

    private boolean attempt(int r, int c) {
        return game.makeMove(type, r, c);
    }
}
