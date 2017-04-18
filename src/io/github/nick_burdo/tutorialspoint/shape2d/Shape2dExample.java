package io.github.nick_burdo.tutorialspoint.shape2d;/**
 * Created by tigra on 18.04.17.
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class Shape2dExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Line line = new Line();
        line.setStartX(50.0f);
        line.setStartY(50.0f);
        line.setEndX(50.0f);
        line.setEndY(350.0f);

        Path star = new Path(
                new MoveTo(232, 52),
                new LineTo(269, 250),
                new LineTo(108, 71),
                new LineTo(321, 161),
                new LineTo(126, 232),
                new LineTo(232, 52)
                );

        Group root = new Group(line, star);
        Scene scene = new Scene(root);

        primaryStage.setTitle("Shape2d Example");
        primaryStage.setHeight(400);
        primaryStage.setWidth(400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
