package XO;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {

    protected final char[][] gameBoard = new char[5][5];
    protected PlayerType turn = PlayerType.X;
    protected volatile boolean gameOver = false;
    protected volatile PlayerType winner = null;

    public Game() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                gameBoard[i][j] = '.';
            }
        }
    }

    public synchronized PlayerType getTurn() {
        return turn;
    }

    public synchronized List<Cell> getFreeCells() {
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameBoard[i][j] == '.') {
                    cells.add(new Cell(i, j));
                }
            }
        }
        return cells;
    }

    public synchronized void printBoard() {
        for (int i = 0; i < 5; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                sb.append(gameBoard[i][j]);
                if (j < 4) sb.append(' ');
            }
            System.out.println(sb.toString());
        }
        System.out.println();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public PlayerType getWinner() {
        return winner;
    }

    protected synchronized boolean makeMove(PlayerType type, int row, int col) {
        if (gameOver) return false;
        if (type != turn) return false;
        if (row < 0 || row >= 5 || col < 0 || col >= 5) return false;
        if (gameBoard[row][col] != '.') return false;

        gameBoard[row][col] = (type == PlayerType.X) ? 'X' : 'O';

        if (checkWin(gameBoard[row][col])) {
            winner = type;
            gameOver = true;
            return true;
        }

        if (isBoardFullNoLock()) {
            System.out.println("full is Board");
            gameOver = true;
            return true;
        }

        turn = (turn == PlayerType.X) ? PlayerType.O : PlayerType.X;
        return true;
    }

    private boolean isBoardFullNoLock() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameBoard[i][j] == '.') return false;
            }
        }
        return true;
    }

    private boolean checkWin(char s) {
        int need = 4;

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c <= 5 - need; c++) {
                boolean ok = true;
                for (int k = 0; k < need; k++) {
                    if (gameBoard[r][c + k] != s) {
                        ok = false;
                        break;
                    }
                }
                if (ok) return true;
            }
        }

        for (int c = 0; c < 5; c++) {
            for (int r = 0; r <= 5 - need; r++) {
                boolean ok = true;
                for (int k = 0; k < need; k++) {
                    if (gameBoard[r + k][c] != s) {
                        ok = false;
                        break;
                    }
                }
                if (ok) return true;
            }
        }

        for (int r = 0; r <= 5 - need; r++) {
            for (int c = 0; c <= 5 - need; c++) {
                boolean ok = true;
                for (int k = 0; k < need; k++) {
                    if (gameBoard[r + k][c + k] != s) {
                        ok = false;
                        break;
                    }
                }
                if (ok) return true;
            }
        }

        for (int r = 0; r <= 5 - need; r++) {
            for (int c = need - 1; c < 5; c++) {
                boolean ok = true;
                for (int k = 0; k < need; k++) {
                    if (gameBoard[r + k][c - k] != s) {
                        ok = false;
                        break;
                    }
                }
                if (ok) return true;
            }
        }

        return false;
    }
}
