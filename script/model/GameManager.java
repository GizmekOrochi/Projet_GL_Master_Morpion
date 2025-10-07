package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private List<PlayerMove> history = new ArrayList<>();

    public void initializeGame() {}

    public void gameLoop() {
        for(Player p : players) {
            playerTurn(p);
            if(checkEndOfGame())
                break;
        }
    }

    public void playerTurn(Player player) {
        PlayerMove move = player.takeTurn();
        updateHistory(move);
        updatePlayerGrid(move);
        updatePlayerScore(move);
    }

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
    // checkAllCellSequences → comptabilise les scores toutes les séquences passant par une cellule donnée
    private int[] checkAllCellSequences(int x, int y) {
        int[] scores = new int[players.size()];

        // Ensemble des cellules déjà utilisées par une séquence gagnante
        Set<int[]> usedCells = new HashSet<>();

        // Les 4 directions à explorer : → ↓ ↘ ↗
        int[][] directions = {
                {1, 0},  // ligne horizontale
                {0, 1},  // colonne verticale
                {1, 1},  // diagonale ↘
                {1, -1}  // diagonale ↗
        };

        for (int[] dir : directions) {
            int dx = dir[0];
            int dy = dir[1];

            // On va tester toutes les positions de départ possibles d'une séquence
            for (int offset = -(sequence_length - 1); offset <= 0; offset++) {
                CellContent[] sequence = new CellContent[sequence_length];
                List<int[]> sequencePoints = new ArrayList<>();

                // Construction de la séquence
                for (int k = 0; k < sequence_length; k++) {
                    int newX = x + (offset + k) * dx;
                    int newY = y + (offset + k) * dy;

                    sequence[k] = gameGrid.getCell(newX, newY);
                    sequencePoints.add(new int[]{newX, newY});
                }

                // Vérifie si la séquence est gagnante (et non nulle)
                if (checkSequence(sequence)) {
                    // Vérifie si une des cellules est déjà utilisée
                    boolean overlap = sequencePoints.stream().anyMatch(usedCells::contains);
                    if (!overlap) {
                        // Séquence valide et non-overlappée : on compte le point
                        int player = ((Symbol) sequence[0]).getSymbol().ordinal();
                        scores[player]++;

                        // Et on marque les cellules comme utilisées
                        usedCells.addAll(sequencePoints);
                    }
                }
            }
        }

        return scores;
    }
    // checkFullBoard → vérifie si le plateau est plein ou non
    private boolean checkFullBoard() {
        boolean result = true;
        int[] boardSize = gameGrid.getSize();
        for(int i = 0; i < boardSize[0]; i++) {
            for (int j = 0; j < boardSize[1]; j++) {
                result = result && gameGrid.getCell(i, j) instanceof EmptyCell;
            }
        }
        return result;
    }
    // checkEndOfGame → vérifie toutes les séquences de toutes les cases
    public boolean checkEndOfGame() {
        boolean result = checkFullBoard();

        // default winCondition
        if (!result && winCondition == 0) {
            for(Player p : players) {
                if (p.getScore() > 0) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }
    // =============================================

    // =============================================
    // UPDATES
    private void updateHistory(PlayerMove move) {
        // On n'ajoute le move à l'historique QUE si c'est un ajout
        if(move.getAction() == 1)
            history.add(move);
            // Si ce n'est pas un ajout, il faut retirer le move correspondant dans l'historique
        else {
            history.removeIf(m -> m.corresponds(move));
        }
    }
    public void updatePlayerGrid(PlayerMove move) {
        for(Player p : players)
            p.updateGrid(move);
    }
    public void updatePlayerScore(PlayerMove move) {
        int[] scores = checkAllCellSequences(move.getX(), move.getY());
        for(int i = 0; i < scores.length; i++) {
            Player p = players.get(i);
            p.setScore(p.getScore() + scores[i]);
        }
    }
    // =============================================

    public void gameHint() {}
    public void changeRoles() {}

    public boolean getPause() {
        return pause;
    }

    public void setPause(boolean gameLoop) {
        this.pause = gameLoop;
    }

    public List<PlayerMove> getHistory() {
        return history;
    }

    public void setHistory(List<PlayerMove> history) {
        this.history = history;
    }
}
