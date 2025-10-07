package model.grid;

import model.util.EnumSymbols;

public abstract class CellContent {
    protected int Xpos;
    protected int Ypos;

    CellContent(int x, int y) {
        this.Xpos = x;
        this.Ypos = y;
    }

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

    public boolean containsSymbol(EnumSymbols symbol) {
        if(this instanceof Symbol symbol1)
            return symbol1.getSymbol() == symbol;
        else return false;
    }
}
