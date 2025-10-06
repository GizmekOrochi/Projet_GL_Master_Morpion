package model;

public class GameGrid {
    private int sizeX;
    private int sizeY;
    private CellContent[][] grid;

    public GameGrid(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        initializeGrid();
    }

    public int[] getSize() {
        return new int[]{sizeX, sizeY};
    }

    public void setSize(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        initializeGrid();
    }

    public void initializeGrid() {
        grid = new CellContent[sizeX][sizeY];
    }

    public void setCell(int x, int y, CellContent content) {
        if (inBounds(x, y)) {
            grid[x][y] = content;
            if (content != null) {
                content.setXpos(x);
                content.setYpos(y);
            }
        }
    }

    public CellContent getCell(int x, int y) {
        if (inBounds(x, y)) {
            return grid[x][y];
        }
        return null;
    }

    public void clearGrid() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                grid[i][j] = null;
            }
        }
    }

    public boolean inBounds(int x, int y) {
        return x >= 0 && x < sizeX && y >= 0 && y < sizeY;
    }
}
