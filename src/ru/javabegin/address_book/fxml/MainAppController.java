package ru.javabegin.address_book.fxml;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import ru.javabegin.address_book.start.Main;
import ru.javabegin.address_book.utils.DialogManager;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainAppController implements Initializable {
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
    private EditDialogController editDialogController;
    private Stage editDialogStage;
    private Stage mainAppStage;
    private ResourceBundle resourceBundle;
    private CollectionAddressBook addressBook = new CollectionAddressBook();

    private ObservableList<Person> backupList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;
        columnName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        initListeners();

        addressBook.fillTestData();
        backupList = FXCollections.observableArrayList();
        backupList.addAll(addressBook.getPersonList());

        tableAddressBook.setItems(addressBook.getPersonList());

        initLoader();
    }

    public void setMainAppStage(Stage mainAppStage) {
        this.mainAppStage = mainAppStage;
    }

    public void actionButtonPressed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) return;

        Button clickedBtn = (Button) source;
        Person selectedPerson = (Person) tableAddressBook.getSelectionModel().getSelectedItem();
        Window parentWindow = ((Node) actionEvent.getSource()).getScene().getWindow();

        switch (clickedBtn.getId()) {
            case "btnAdd":
                editDialogController.setPerson(new Person());
                showEditDialog(resourceBundle.getString("key.title.add"));
                addressBook.add(editDialogController.getPerson());
                break;
            case "btnEdit":
                if (!isSelectedPerson(selectedPerson)) {
                    return;
                }
                editDialogController.setPerson(selectedPerson);
                showEditDialog(resourceBundle.getString("key.title.edit"));
                break;
            case "btnDelete":
                if (!isSelectedPerson(selectedPerson)) {
                    return;
                }
                addressBook.delete(selectedPerson);
                break;
        }
    }

    public void actionSearch(ActionEvent actionEvent) {
        addressBook.getPersonList().clear();

        for (Person person: backupList) {
            if (person.getName().toLowerCase().contains(txtSearch.getText().toLowerCase()) ||
                    person.getPhone().toLowerCase().contains(txtSearch.getText().toLowerCase())) {
                addressBook.getPersonList().add(person);
            }
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
                    showEditDialog(resourceBundle.getString("key.title.edit"));
                }
            }
        });
    }

    private void initLoader() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("editDialog.fxml"));
            fxmlLoader.setResources(ResourceBundle.getBundle("ru.javabegin.address_book.bundles.Locale", new Locale("ru")));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isSelectedPerson(Person selectedPerson) {
        if (selectedPerson == null) {
            DialogManager.showErrorDialog(resourceBundle.getString("key.dialog.title.error"), resourceBundle.getString("key.dialog.select_person"));
            return false;
        }
        return true;
    }

    private void updateLabelCount() {
        labelCount.setText(addressBook.getPersonList().size() + "");
    }

    private void showEditDialog(String title) {
        if (editDialogStage == null) {
            editDialogStage = new Stage();
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainAppStage);
        }

        editDialogStage.setTitle(title);
        editDialogStage.showAndWait();
    }
}
