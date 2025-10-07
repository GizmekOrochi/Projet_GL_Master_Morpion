package view;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public abstract class Scene extends Application{

    private Pane[] element;

    public void display() {}

    public void update() {}

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Morpion");
        primaryStage.setScene(new Scene(new Pane(), 800, 600));
        primaryStage.show();
    }

}
