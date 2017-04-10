package ru.javabegin.address_book.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.javabegin.address_book.fxml.MainAppController;
import ru.javabegin.address_book.interfaces.impl.CollectionAddressBook;
import ru.javabegin.address_book.objects.Person;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../fxml/mainApp.fxml"));
        Parent fxmlMain = fxmlLoader.load();
        MainAppController mainAppController = fxmlLoader.getController();
        mainAppController.setMainAppStage(primaryStage);

        primaryStage.setTitle("Address Book");
        primaryStage.setMinWidth(340);
        primaryStage.setMinHeight(425);
        primaryStage.setScene(new Scene(fxmlMain, 340, 425));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
