package ru.javabegin.address_book.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.javabegin.address_book.interfaces.impl.CollectionAddressBook;
import ru.javabegin.address_book.objects.Person;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/mainApp.fxml"));
        primaryStage.setTitle("Address Book");
        primaryStage.setMinWidth(340);
        primaryStage.setMinHeight(425);
        primaryStage.setScene(new Scene(root, 340, 425));
        primaryStage.show();

        testData();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void testData() {
        CollectionAddressBook addressBook = new CollectionAddressBook();

        Person person1 = new Person();
        person1.setName("test1");
        person1.setPhone("123456789");

        Person person2 = new Person();
        person2.setName("test2");
        person2.setPhone("777777777777");

        addressBook.add(person1);
        addressBook.add(person2);

        person2.setPhone("111111111111");

        addressBook.delete(person2);
    }
}
