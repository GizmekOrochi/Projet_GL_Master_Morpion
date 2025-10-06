package model;

import java.util.ArrayList;
import java.util.List;

public class GameGrid {
    private int sizeX;
    private int sizeY;
    private List<GamePlay> history = new ArrayList<>();

    public int[] getSize() {
        return new int[]{sizeX, sizeY};
    }

    public void setSize(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public List<GamePlay> getHistory() {
        return history;
    }

    public void setHistory(List<GamePlay> history) {
        this.history = history;
    }

    // Optionnel : utilitaires pratiques

    public void addPlay(GamePlay play) {
        history.add(play);
    }

    public GamePlay undoLastPlay() {
        if (!history.isEmpty()) {
            return history.remove(history.size() - 1);
        }
        return null;
    }
}
