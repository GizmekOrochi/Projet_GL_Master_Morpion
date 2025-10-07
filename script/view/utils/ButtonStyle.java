package utils;

import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

public class ButtonStyle extends Button {
    
    public ButtonStyle(String text) {
        super(text);

        setPrefSize(220, 115);  // taille préférée  
        setTextAlignment(TextAlignment.CENTER);
        this.setStyle(
            "-fx-font-size: 30px; " +
            "-fx-font-weight: bold; " +
            "-fx-text-fill: #2B0040; " +
            "-fx-background-color: #C5A0D7; " +
            "-fx-background-radius: 8px; "+
            "-fx-alignment: center;"
            );
    }

}
