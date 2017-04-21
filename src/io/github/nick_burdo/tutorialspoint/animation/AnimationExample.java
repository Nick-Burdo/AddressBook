package io.github.nick_burdo.tutorialspoint.animation;/**
 * Created by tigra on 21.04.17.
 */

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Polygon hexagon = new Polygon();
        hexagon.getPoints().addAll(new Double[]{
                200.0, 50.0,
                400.0, 50.0,
                450.0, 150.0,
                400.0, 250.0,
                200.0, 250.0,
                150.0, 150.0,
        });
        hexagon.setFill(Color.BLUE);

        RotateTransition transition = new RotateTransition();
        transition.setDuration(Duration.millis(1000));
        transition.setNode(hexagon);
        transition.setByAngle(360);
        transition.setCycleCount(50);
        transition.setAutoReverse(false);
        transition.play();

        Group root = new Group(hexagon);
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("Animation Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
