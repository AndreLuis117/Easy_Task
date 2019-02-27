package front;

import back_end.core.Sessao;
import back_end.entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class Controller_Tela_Login {
    @FXML
    public TextField emailField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public Label msgLogin;

    public void loginClick(ActionEvent mouseEvent) {

     if (Sessao.validarLogin(emailField.getText(), passwordField.getText())){
         User user = new User();

         user.setPassword(passwordField.getText());

         user.setEmail(emailField.getText());

         Sessao.fazerLogin(user);

         try {
             FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("TelaHome.fxml")));
             Parent root = loader.load();
             Controller_Tela_Home controller = loader.getController();
             Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
             primaryStage.setScene(new Scene(root));
         } catch (Exception e) {
             e.printStackTrace();


         }

     }
     else{
         msgLogin.setText("Usuário e/ou senha errado!");











    }

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

