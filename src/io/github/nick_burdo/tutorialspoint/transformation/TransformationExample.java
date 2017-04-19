package io.github.nick_burdo.tutorialspoint.transformation;/**
 * Created by tigra on 19.04.17.
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class TransformationExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Rectangle rectangle = new Rectangle(50, 50, 100, 75);
        rectangle.setFill(Color.BURLYWOOD);
        rectangle.setStroke(Color.BLACK);

        Rotate rotate = new Rotate(20, 150, 225);
        Scale scale = new Scale(1.5, 1.5, 300, 135);
        Translate translate = new Translate(250, 0, 0);

        rectangle.getTransforms().addAll(rotate, scale, translate);

        Group root = new Group(rectangle);

        Scene scene = new Scene(root, 600, 300);

        primaryStage.setTitle("Multiple transform");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
