package ru.javabegin.address_book.fxml;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.javabegin.address_book.interfaces.impl.CollectionAddressBook;
import ru.javabegin.address_book.objects.Person;

import java.awt.*;
import java.io.IOException;

public class mainAppController {
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnSearch;
    @FXML
    private TableView tableAddressBook;
    @FXML
    private TableColumn<Person, String> columnName;
    @FXML
    private TableColumn<Person, String> columnPhone;
    @FXML
    private Label labelCount;

    private CollectionAddressBook addressBook = new CollectionAddressBook();

    @FXML
    void initialize() {
        columnName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        addressBook.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateLabelCount();
            }
        });

        addressBook.fillTestData();

        tableAddressBook.setItems(addressBook.getPersonList());

    }

    public void showEditDialog(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("editDialog.fxml"));
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException e) {

            System.out.println("Exception in mainAppController");
            e.printStackTrace();
        }
    }

    public void showDialog(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) return;

        Button clickedBtn = (Button) source;
        Person selectedPerson = (Person) tableAddressBook.getSelectionModel().getSelectedItem();

        switch (clickedBtn.getId()) {
            case "btnAdd":
                System.out.println("add " + selectedPerson);
                break;
            case "btnEdit":
                System.out.println("edit " + selectedPerson);
                break;
            case "btnDelete":
                System.out.println("delete " + selectedPerson);
                break;
        }
    }

    private void updateLabelCount() {
        labelCount.setText(addressBook.getPersonList().size() + "");
    }
}
