package model.util;

import model.grid.Symbol;

public class PlayerMove {
    private Symbol playerSymbol;
    private int x;
    private int y;
    private int action; // 0 = Suppression, 1 = Ajout de symbole

    public PlayerMove(Symbol playerSymbol, int x, int y, int action) {
        this.playerSymbol = playerSymbol;
        this.x = x;
        this.y = y;
        this.action = action;
    }

    public int getAction() {return action;}

    // same coordinates but opposite action
    public boolean corresponds(PlayerMove move) {
        return this.x == move.x && this.y == move.y && this.action != move.action;
    }

    public Symbol getplayerSymbol() {
        return playerSymbol;
    }

    public void setplayerSymbol(Symbol playerSymbol) {
        this.playerSymbol = playerSymbol;
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
