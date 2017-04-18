package io.github.nick_burdo.tutorialspoint.text;/**
 * Created by tigra on 17.04.17.
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        /**
         * prepare scene graph
         *
         * 1. Group
         * 2. Region
         *      - Chart
         *      - Pane
         *      - Control
         * 3. WebView
         */
//        Group root = new Group();
//        ObservableList list = root.getChildren();
//        list.add(new AnchorPane());
        Text text = new Text("Welcome to tutorialspoint");
//        text.setFont(new Font(32));
        text.setX(20);
        text.setY(50);
        text.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 32));
        text.setFill(Color.WHEAT);
        text.setStroke(Color.RED);
        text.setStrokeWidth(1);

        Group root = new Group(text);

        /**
         * prepare scene with required dimensions & add root node of scene graph to it
         */
//        Scene scene = new Scene(root);
        Scene scene = new Scene(root, 600, 200);

        /**
         * prepare stage:
         *      - set title
         *      - set scene
         *      - display stage
         */
        primaryStage.setTitle("Base Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
