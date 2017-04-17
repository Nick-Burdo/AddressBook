package io.github.nick_burdo.tutorialspoint.base;/**
 * Created by tigra on 17.04.17.
 */

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Base extends Application {

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
        Group root = new Group(new AnchorPane());

        /**
         * prepare scene with required dimensions & add root node of scene graph to it
         */
//        Scene scene = new Scene(root);
        Scene scene = new Scene(root, 400, 400);

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
