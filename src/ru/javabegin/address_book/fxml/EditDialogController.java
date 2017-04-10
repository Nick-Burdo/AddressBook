package ru.javabegin.address_book.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.javabegin.address_book.objects.Person;



/**
 * Created by tigra on 07.04.17.
 */
public class EditDialogController {
    @FXML
    private Button btnOK;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField textName;
    @FXML
    private TextField textPhone;

    private Person person;

    @FXML
    void initialize() {
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void actionSave(ActionEvent actionEvent) {
        person.setName(textName.getText());
        person.setPhone(textPhone.getText());
        actionClose(actionEvent);
    }

    public void setPerson(Person person) {
        this.person = person;
        textName.setText(person.getName());
        textPhone.setText(person.getPhone());
    }
}
