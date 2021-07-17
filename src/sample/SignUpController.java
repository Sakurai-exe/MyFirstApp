package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpLastName;

    @FXML
    private Button signUpButton;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField login_field2;

    @FXML
    private TextField signUpCountry;

    @FXML
    private CheckBox signUpCheckboxMale;

    @FXML
    private CheckBox signUpCheckboxFemale;

    @FXML
    void initialize() {


        signUpButton.setOnAction(event -> {

            signUpNewUser();

        });

    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String firstName = signUpName.getText();
        String lastName = signUpLastName.getText();
        String userName = login_field2.getText();
        String password = password_field.getText();
        String location = signUpCountry.getText();
        String gender = "";
        if(signUpCheckboxMale.isSelected())
            gender = "Мужской";
        else
            gender = "Женский";

        User user = new User(firstName, lastName, userName, password, location, gender);

        dbHandler.signUpUser(user);
    }
}
