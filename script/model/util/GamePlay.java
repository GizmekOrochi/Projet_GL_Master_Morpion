package model;

public class GamePlay {
    private int playerIndex;
    private int x;
    private int y;

    public GamePlay(int playerIndex, int x, int y) {
        this.playerIndex = playerIndex;
        this.x = x;
        this.y = y;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
