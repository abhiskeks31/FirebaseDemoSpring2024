package aydin.firebasedemospring2024;

import java.io.IOException;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class SecondaryController {

    @FXML
    private TextField registerNameTxt;

    @FXML
    private TextField registerEmailTxt;

    @FXML
    private TextField registerPassTxt;

    @FXML
    private TextField registerPhoneTxt;

    @FXML
    private Button signInBtn;

    @FXML
    private TextField signInEmailTxt;

    @FXML
    private TextField signInPassTxt;

    @FXML
    private Button registerButton;

    @FXML
    void registerButtonClicked(ActionEvent event) {
        registerUser();
    }

    public boolean registerUser() {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(registerEmailTxt.getText())
                .setEmailVerified(false)
                .setPassword(registerPassTxt.getText())
                .setPhoneNumber(registerPhoneTxt.getText())
                .setDisplayName(registerNameTxt.getText())
                .setDisabled(false);

        UserRecord userRecord;
        try {
            userRecord = DemoApp.fauth.createUser(request);
            System.out.println("Successfully created new user with Firebase Uid: " + userRecord.getUid()
                    + " check Firebase > Authentication > Users tab");
            return true;

        } catch (FirebaseAuthException ex) {
            // Logger.getLogger(FirestoreContext.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error creating a new user in the firebase");
            return false;
        }

    }

    @FXML
    void signInButtonClicked(ActionEvent event) {signInUser();}

    public void signInUser()
    {
        String username = signInEmailTxt.getText();
        String pass = signInPassTxt.getText();


        System.out.println(username);
        System.out.println(pass);
    }

    @FXML
    private void switchToPrimary() throws IOException {
        DemoApp.setRoot("primary");
    }
}