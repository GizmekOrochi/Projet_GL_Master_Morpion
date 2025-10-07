package model.grid;

public class GameGrid {
    private int matrixSizeX;
    private int matrixSizeY;
    private final int listSize;
    private CellContent[] grid;

    public GameGrid(int matrixSizeX, int matrixSizeY) {
        this.matrixSizeX = matrixSizeX;
        this.matrixSizeY = matrixSizeY;
        this.listSize = matrixSizeX*matrixSizeY;
        initializeGrid();
    }

    public int getmatrixSizeX() {
        return matrixSizeX;
    }

    public int getmatrixSizeY() {
        return matrixSizeY;
    }

    public int[] getSize(){
        return new int[]{matrixSizeX,matrixSizeY};
    }
    public void initializeGrid() {
        this.grid = new CellContent[listSize];
        int interator = 0;
        for (int x = 0; x < this.matrixSizeX; x++) {
            for (int y = 0; y < this.matrixSizeY; y++) {
                grid[interator] = new Forbidden(x, y);
                interator++;
            }
        }
    }

    public void setCell(int x, int y, CellContent content) {
        if (inBounds(x, y)) {
            for (int i = 0; i < this.listSize; i++) {
                if(grid[i].getXpos() == x && grid[i].getYpos() == y) {
                    this.grid[i] = content;
                }
            }
        }
    }

    public CellContent getCell(int x, int y) {
        if (inBounds(x, y)) {
            for (int i = 0; i < this.listSize; i++) {
                if(grid[i].getXpos() == x && grid[i].getYpos() == y) {
                    return this.grid[i];
                }
            }
        }
        return null;
    }

    public boolean inBounds(int x, int y) {
        return x >= 0 && x < matrixSizeX && y >= 0 && y < matrixSizeY;
    }

    
}
