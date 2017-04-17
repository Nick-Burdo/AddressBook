package io.github.nick_burdo.tutorialspoint.line;/**
 * Created by tigra on 17.04.17.
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class LineExample extends Application {

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
        Line line = new Line();
        line.setStartX(50);
        line.setStartY(50);
        line.setEndX(350);
        line.setEndY(350);

        Group root = new Group(line);

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
        primaryStage.setTitle("Line Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
