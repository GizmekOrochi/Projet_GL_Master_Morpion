package model;

import java.util.ArrayList;
import java.util.List;
import model.grid.*;
import model.player.*;
import model.util.*;

public class GameManager {
    private int sequence_length;
    private int winCondition = 0;
    private int turnNb;
    private boolean pause;

    private GameGrid gameGrid;
    private List<Player> players = new ArrayList<>();
    private List<HistoryMove> history = new ArrayList<>();

    public void initializeGame() {}
    public void gameLoop() {}

    // =============================================
    // CHECKS : symbol sequences & end of game
    // checkSequence → vérifie une séquence donnée
    private boolean checkSequence(CellContent[] sequence) {
        if (sequence[0] == null || !(sequence[0] instanceof Symbol)) {
            return false;
        }

        EnumSymbols symbol = ((Symbol)sequence[0]).getSymbol();
        for (CellContent c : sequence) {
            if (c == null || !c.containsSymbol(symbol)) {
                return false;
            }
        }
        return true;
    }
    // checkAllCellSequences → vérifie toutes les séquences passant par une cellule donnée
    private boolean checkAllCellSequences(int x, int y) {
        boolean result = true;

        int[][] directions = {
                {1, 0},  // ligne horizontale
                {0, 1},  // colonne verticale
                {1, 1},  // diagonale ↘
                {1, -1}  // diagonale ↗
        };

        for(int[] dir : directions) {
            int dx = dir[0];
            int dy = dir[1];

            for (int offset = -(sequence_length - 1); offset <= 0; offset++) {
                CellContent[] sequence = new CellContent[sequence_length];

                for (int k = 0; k < sequence_length; k++) {
                    int newX = x + (offset + k) * dx;
                    int newY = y + (offset + k) * dy;

                    sequence[k] = gameGrid.getCell(newX, newY);
                }

                // On vérifie la séquence
                result = result & checkSequence(sequence);
            }
        }

        return result;
    }
    // checkEndOfGame → vérifie toutes les séquences de toutes les cases
    public boolean checkEndOfGame() {
        boolean result = true;

        // default winCondition
        if (winCondition == 0) {
            int[] boardSize = gameGrid.getSize();
            for(int i = 0; i < boardSize[0]; i++) {
                for(int j = 0; j < boardSize[1]; j++) {
                    result = result & checkAllCellSequences(i, j);
                }
            }
        }

        return result;
    }
    // =============================================

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

    public List<HistoryMove> getHistory() {
        return history;
    }

    public void setHistory(List<HistoryMove> history) {
        this.history = history;
    }

    public void addPlay(HistoryMove play) {
        history.add(play);
    }

    public HistoryMove undoLastPlay() {
        if (!history.isEmpty()) {
            return history.removeLast();
        }
        return null;
    }
}
