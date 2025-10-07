package model.player;

import model.grid.AlgorithmGrid;
import model.util.PlayerMove;

public class AIPlayer extends Player {
    private int agressivity;
    private AlgorithmGrid algorithmGrid;

    public int getAgressivity() {
        return agressivity;
    }

    public void setAgressivity(int agressivity) {
        this.agressivity = agressivity;
    }

    @Override
    public PlayerMove takeTurn() {
        // logique IA
        return null;
    }
}
