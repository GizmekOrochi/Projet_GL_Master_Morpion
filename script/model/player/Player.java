package model.player;

import model.grid.AlgorithmGrid;
import model.util.PlayerMove;

public abstract class Player {
    private AlgorithmGrid grid;
    private int score;

    public abstract PlayerMove takeTurn();
    public void placeSymbol() {}
    public void removeSymbol() {}

    public void updateGrid(PlayerMove move) {
        grid.updateGrid(move);
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
