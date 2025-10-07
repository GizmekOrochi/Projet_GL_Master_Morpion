package model.grid;

public abstract class CellContent {
    protected int Xpos;
    protected int Ypos;

    public int getXpos() {
        return Xpos;
    }

    public void setXpos(int xpos) {
        this.Xpos = xpos;
    }

    public int getYpos() {
        return Ypos;
    }

    public void setYpos(int ypos) {
        this.Ypos = ypos;
    }
}
