package model.player;

import model.grid.AlgorithmGrid;
import model.util.HistoryMove;

public abstract class Player {
    private AlgorithmGrid grid;
    private int score;

    public abstract HistoryMove takeTurn();
    public void placeSymbol() {}
    public void removeSymbol() {}

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
