package model;

public class GameGrid {
    private int sizeX;
    private int sizeY;
    private T_stack history; // à définir selon ton projet

    public int[] getSize() {
        return new int[]{sizeX, sizeY};
    }

    public void setSize(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public T_stack getHistory() {
        return history;
    }

    public void setHistory(T_stack historic) {
        this.history = historic;
    }
}
