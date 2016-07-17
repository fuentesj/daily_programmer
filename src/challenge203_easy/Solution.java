package challenge203_easy;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by jon on 2/24/15.
 */
public class Solution extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300, Color.BLACK);

        final Canvas canvas = new Canvas(250, 250);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(75, 75, 150, 150);

        root.getChildren().add(canvas);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
