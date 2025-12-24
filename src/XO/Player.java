package XO;

public abstract class Player extends Thread {

    protected final PlayerType type;
    protected final Game game;

    public Player(PlayerType type, Game game) {
        this.type = type;
        this.game = game;
    }
}
