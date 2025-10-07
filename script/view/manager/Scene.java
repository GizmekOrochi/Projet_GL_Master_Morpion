package view;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.*;



public abstract class Scene extends Application{

    private Pane[] element;

    public void display() {}

    public void update() {}

    public void start(Stage primaryStage) throws Exception {

        StackPane root = new StackPane();

        CreateGameScene createGameScene = new CreateGameScene(root, primaryStage);

        primaryStage.setTitle("Morpion");
        primaryStage.setScene(createGameScene);
        primaryStage.show();
    }

}
