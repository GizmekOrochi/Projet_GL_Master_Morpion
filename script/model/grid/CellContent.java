package model.grid;

import model.util.EnumSymbols;

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

    public boolean containsSymbol(EnumSymbols symbol) {
        if(this instanceof Symbol)
            return ((Symbol) this).getSymbol() == symbol;
        else return false;
    }
}
