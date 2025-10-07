package model.grid;

import model.util.EnumSymbols;

public class Symbol extends CellContent {
    private EnumSymbols symbol;

    public Symbol(int x, int y, EnumSymbols symbol) {
        super(x, y);
        this.symbol = symbol;
    }

    public EnumSymbols getSymbol() {
        return symbol;
    }

    public void setSymbol(EnumSymbols symbol) {
        this.symbol = symbol;
    }
}
