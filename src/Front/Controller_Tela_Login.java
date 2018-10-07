package Front;

import Easy_Task.core.Sessao;
import Easy_Task.entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller_Tela_Login {//implements Initializable {
    @FXML
    public TextField emailField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public Label msgLogin;

    public void loginClick(ActionEvent mouseEvent) {

     if (Sessao.validarLogin(emailField.getText(), passwordField.getText()) == true){
         User user = new User();
         Sessao sessao = new Sessao();

         user.setPassword(passwordField.getText());

         user.setEmail(emailField.getText());
         Sessao.fazerLogin(user);

         try {
             FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("TelaHome.fxml")));
             Parent root = loader.load();
             Controller_Tela_Home controller = loader.getController();
             Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
             //controller.setPreviousScene(primaryStage.getScene());
             primaryStage.setScene(new Scene(root));
         } catch (Exception e) {
             e.printStackTrace();


         }

     }
     else{
         msgLogin.setText("Usuário e/ou senha errado!");











    }

    //@Override
    //public void initialize(URL location, ResourceBundle resources) {


    }

    public void noAccountClick(ActionEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("TelaDeCadastroUsuario.fxml")));

            Parent root = loader.load();
            Controller_Tela_Cadastro controller = loader.getController();
            Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            controller.setPreviousScene(primaryStage.getScene());
            primaryStage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

