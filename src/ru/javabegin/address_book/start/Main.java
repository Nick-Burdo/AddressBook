package ru.javabegin.address_book.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.javabegin.address_book.interfaces.impl.CollectionAddressBook;
import ru.javabegin.address_book.objects.Person;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/mainApp.fxml"));
        primaryStage.setTitle("Address Book");
        primaryStage.setMinWidth(340);
        primaryStage.setMinHeight(425);
        primaryStage.setScene(new Scene(root, 340, 425));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
