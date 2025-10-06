package model;

public abstract class Player {
    protected int score;

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
