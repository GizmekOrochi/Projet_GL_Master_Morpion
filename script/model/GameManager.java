package model;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private int sequence_length;
    private int winCondition;
    private int turnNb;
    private boolean pause;

    private GameGrid gameGrid;
    private List<Player> players = new ArrayList<>();
    private List<GamePlay> history = new ArrayList<>();

    public void initializeGame() {}
    public void gameLoop() {}
    public void checkEndOfGame() {}
    public void playerTurn(Player player) {}
    public void gameHint() {}
    public void changeRoles() {}
    public void updatePlayerGrid() {}
    public void updatePlayerScore() {}
    
    public boolean getPause() {
        return pause;
    }

    public void setPause(boolean gameLoop) {
        this.pause = gameLoop;
    }

        public List<GamePlay> getHistory() {
        return history;
    }

    public void setHistory(List<GamePlay> history) {
        this.history = history;
    }

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
