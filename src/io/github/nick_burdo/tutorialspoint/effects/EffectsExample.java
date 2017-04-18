package io.github.nick_burdo.tutorialspoint.effects;/**
 * Created by tigra on 18.04.17.
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class EffectsExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ImageView imageView = new ImageView(new Image("https://www.tutorialspoint.com/green/images/logo.png"));

        imageView.setX(50);
        imageView.setY(50);
        imageView.setFitWidth(400);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);

        Glow glow = new Glow();
        glow.setLevel(0.5);
        imageView.setEffect(glow);

        Group root = new Group(imageView);
        Scene scene = new Scene(root);

        primaryStage.setTitle("Effects Example");
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
