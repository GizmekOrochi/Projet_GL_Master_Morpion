package model;

import java.util.ArrayList;
import java.util.List;

public class GameGrid {
    private int sizeX;
    private int sizeY;
    private Symbol[][] grid;

    public GameGrid(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.grid = new Symbol[sizeX][sizeY];
    }

    public GameGrid() {}

    public int[] getSize() {
        return new int[]{sizeX, sizeY};
    }

    public void setSize(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.grid = new Symbol[sizeX][sizeY];
    }

    public void initializeGrid(Symbol defaultValue) {
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                grid[x][y] = defaultValue;
            }
        }
    }

    public void setCell(int x, int y, Symbol symbol) {
        if (inBounds(x, y)) {
            grid[x][y] = symbol;
        } else {
            throw new IndexOutOfBoundsException("Coordinates out of bounds: " + x + ", " + y);
        }
    }

    public Symbol getCell(int x, int y) {
        if (inBounds(x, y)) {
            return grid[x][y];
        }
        throw new IndexOutOfBoundsException("Coordinates out of bounds: " + x + ", " + y);
    }

    public void clearGrid() {
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                grid[x][y] = null;
            }
        }
    }

    private boolean inBounds(int x, int y) {
        return x >= 0 && x < sizeX && y >= 0 && y < sizeY;
    }
}