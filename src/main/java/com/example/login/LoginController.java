package com.example.login;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class LoginController {
    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnOK;

    // A series of checks to discover whether the text fields contain
    // the correct information to proceed.
    // Never advise the user that they have incorrectly used the username
    // as this can be used to bruteforce the use of the correct password.
    @FXML
    public void onOKButtonClick(){
        // Both of these values will be hidden naturally
        // so it's not good practice to leave username and password on display
        String username = "admin";
        String password = "PaSSword!!!";

        if(txtUsername.getText().toLowerCase().equals(username) && txtPassword.getText().equals(password)){
            Alert b;
            b = new Alert(Alert.AlertType.INFORMATION, "Access Granted!", ButtonType.OK);
            b.showAndWait();
            resetTextFields();
            // switch scene at this stage :)
        }
        else {
            Alert a;
            a = new Alert(Alert.AlertType.ERROR, "Username or Password not recognised!", ButtonType.OK);
            a.showAndWait();
            resetTextFields();
        }
    }

    // This is one method used to close down the application
    // if someone cancels the login process, they are
    // closing down the entire application.
    @FXML
    public void onCancelButtonClick(){
        Platform.exit();
    }

    // Associated with the view's reset button
    @FXML
    public void onResetButtonClick(){
        resetTextFields();
    }

    // ResetTextFields is recycled throughout the application
    // You could simply add the two lines into onResetButtonClick()
    // and use this, and although this is efficient it does not
    // read well.
    public void resetTextFields(){
        txtUsername.setText("");
        txtPassword.setText("");
        btnOK.setDisable(true); // resets the OK button back to reset for continuity
    }

    // OK button set to disabled on view prevents the use of this
    // button until both username and password text fields have been
    // filled.
    public void activateOKButton(){
        if (!txtUsername.getText().isEmpty() && !txtPassword.getText().isEmpty()){
            btnOK.setDisable(false);
        }
        else {
            btnOK.setDisable(true);
        }
    }
}