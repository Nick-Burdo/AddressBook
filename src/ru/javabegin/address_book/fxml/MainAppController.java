package ru.javabegin.address_book.fxml;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import ru.javabegin.address_book.interfaces.impl.CollectionAddressBook;
import ru.javabegin.address_book.objects.Person;

import java.io.IOException;

public class MainAppController {
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

    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private EditDialogController editDialogController;
    private Stage editDialogStage;
    private Stage mainAppStage;

    public Stage getMainAppStage() {
        return mainAppStage;
    }

    public void setMainAppStage(Stage mainAppStage) {
        this.mainAppStage = mainAppStage;
    }

    private CollectionAddressBook addressBook = new CollectionAddressBook();

    @FXML
    void initialize() {
        columnName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        initListeners();

        addressBook.fillTestData();

        tableAddressBook.setItems(addressBook.getPersonList());

        initLoader();
    }

    public void actionButtonPressed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) return;

        Button clickedBtn = (Button) source;
        Person selectedPerson = (Person) tableAddressBook.getSelectionModel().getSelectedItem();
        Window parentWindow = ((Node) actionEvent.getSource()).getScene().getWindow();

        if (selectedPerson == null) {
            selectedPerson = new Person();
        }


        switch (clickedBtn.getId()) {
            case "btnAdd":
                editDialogController.setPerson(new Person());
                showEditDialog();
                addressBook.add(editDialogController.getPerson());
                break;
            case "btnEdit":
                editDialogController.setPerson(selectedPerson);
                showEditDialog();
                break;
            case "btnDelete":
                addressBook.delete(selectedPerson);
                break;
        }
    }

    private void initListeners() {
        addressBook.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateLabelCount();
            }
        });

        tableAddressBook.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    Person selectedPerson = (Person) tableAddressBook.getSelectionModel().getSelectedItem();
                    editDialogController.setPerson(selectedPerson);
                    showEditDialog();
                }
            }
        });
    }

    private void initLoader() {
        try {
            fxmlLoader.setLocation(getClass().getResource("editDialog.fxml"));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateLabelCount() {
        labelCount.setText(addressBook.getPersonList().size() + "");
    }

    private void showEditDialog() {
        if (editDialogStage == null) {
            editDialogStage = new Stage();
            editDialogStage.setTitle("Edit Record");
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainAppStage);
        }

        editDialogStage.showAndWait();
    }
}
