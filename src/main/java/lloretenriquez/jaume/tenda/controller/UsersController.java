package lloretenriquez.jaume.tenda.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lloretenriquez.jaume.tenda.classes.Person;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UsersController implements Initializable {
    @FXML
    private ListView<String> usersList;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField birthdateField;

    private ObservableList<String> list = FXCollections.observableArrayList();
    private ArrayList<Person> persons = new ArrayList<>();

    @FXML
    protected void create(){
        usersList.getSelectionModel().select(null);
        usernameField.setText("");
        nameField.setText("");
        birthdateField.setText("");
    }


    @FXML
    protected void loadAllData(){
        int index = usersList.getSelectionModel().getSelectedIndex();
        usernameField.setText(persons.get(index).getUsername());
        nameField.setText(persons.get(index).getName());
        birthdateField.setText(persons.get(index).getBirthdate());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }

    private void loadData(){
        persons.add(new Person("IElMinecraft", "Jaume", "dd/mm/aaaa"));
        list.add(persons.get(0).getUsername());
        usersList.getItems().addAll(list);
    }
}
