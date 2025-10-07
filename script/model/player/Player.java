package model.player;

import model.grid.AlgorithmGrid;

public abstract class Player {
    private AlgorithmGrid grid;
    private int score;

    public abstract void takeTurn();
    public void placeSymbol() {}
    public void removeSymbol() {}

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
