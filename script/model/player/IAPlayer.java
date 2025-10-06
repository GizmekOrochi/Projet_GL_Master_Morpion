package model;

public class IAPlayer extends Player {
    private int agressivity;
    private AlgorithmGrid algorithmGrid;

    public int getAgressivity() {
        return agressivity;
    }

    public void setAgressivity(int agressivity) {
        this.agressivity = agressivity;
    }

    @Override
    public void takeTurn() {
        // logique IA
    }
}
