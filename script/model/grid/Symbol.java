package model.grid;

import model.util.EnumSymbols;

public class Symbol extends CellContent {
    private EnumSymbols symbol;

    public EnumSymbols getSymbol() {
        return symbol;
    }

    public void setSymbol(EnumSymbols symbol) {
        this.symbol = symbol;
    }
}
