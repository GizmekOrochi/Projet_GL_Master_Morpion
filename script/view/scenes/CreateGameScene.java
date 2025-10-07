package view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;


import javafx.geometry.Pos;


public class CreateGameScene extends Scene {


    public CreateGameScene(StackPane root, Stage primaryStage) {
        super(root, 1920, 1080);

        // Title
        Label titleLabel = new Label("Game of Morpion");
        titleLabel.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #FFFFFF;-fx-font-family: 'Arial Black';");
        titleLabel.setTranslateY(-200);

        // Buttons
            GridPane buttonPane = new GridPane(20, 20);

            // Start Game Button
            Button startGameButton = new Button("Start Game");
            startGameButton.setOnAction(e -> launchGame());

            // Settings Button
            Button settingsButton = new Button("Settings");
            settingsButton.setOnAction(e -> openSettingMenu());

            // Add buttons to the grid pane
            buttonPane.add(startGameButton, 0, 0);
            buttonPane.add(settingsButton, 1, 0);

            // Center the button pane
            buttonPane.setAlignment(Pos.CENTER);

        root.getChildren().addAll(titleLabel, buttonPane);
    }

    public void launchGame() {
        // Logic to launch the game
        System.out.println("Launching game ...");
    }

    public void openSettingMenu() {
        // Logic to open the settings scene
        System.out.println("Opening settings menu...");
    }
}
