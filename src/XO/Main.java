package XO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose game version:");
        System.out.println("1 - Self vs Self");
        System.out.println("2 - Self vs User");
        int choice = scanner.nextInt();

        Game game;
        Player p1;
        Player p2;

        if (choice == 2) {
            game = new UserGame();
            p1 = new SelfPlayer(PlayerType.X, game);
            p2 = new UserPlayer(PlayerType.O, game, scanner);
        } else {
            game = new SelfGame();
            p1 = new SelfPlayer(PlayerType.X, game);
            p2 = new SelfPlayer(PlayerType.O, game);
        }

        game.printBoard();

        p1.start();
        p2.start();

        p1.join();
        p2.join();

        if (game.getWinner() != null) {
            System.out.println("Winner: " + game.getWinner());
        } else {
            System.out.println("No winner");
        }
    }
}
