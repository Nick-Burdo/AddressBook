package ru.javabegin.address_book.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.javabegin.address_book.objects.Person;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by tigra on 07.04.17.
 */
public class EditDialogController implements Initializable {
    @FXML
    private Button btnOK;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField textName;
    @FXML
    private TextField textPhone;

    private Person person;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
    public Person getPerson() {
        return person;
    }
}
