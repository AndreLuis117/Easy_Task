package front;

import back_end.dao.UserDAO;
import back_end.entity.User;
import front.Controller_Tela_Login;
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

public class Controller_Tela_Cadastro {
    @FXML
    public TextField nomeField;
    @FXML
    public TextField sobrenomeField;
    @FXML
    public TextField emailField;
    @FXML
    public PasswordField senhaCadField;
    @FXML
    public PasswordField confSenhaField;
    @FXML
    public Label msgErroCad;

    private Scene previousScene;


    public void setPreviousScene(Scene scene) {
        this.previousScene = scene;
    }

    public void confirmarCadastro(ActionEvent actionEvent) {
        UserDAO userDAO = new UserDAO();

        if (userDAO.validarEmail(emailField.getText()) == false) {
            if (senhaCadField.getText().equals(confSenhaField.getText())){
                User user = new User();
                UserDAO userdao = new UserDAO();
                user.setName(nomeField.getText());
                user.setLastname(sobrenomeField.getText());
                user.setEmail(emailField.getText());
                user.setPassword(senhaCadField.getText());
                userDAO.insert(user);
                msgErroCad.setText("Cadastro efetuado com suceesso");
            }
            else {
                msgErroCad.setText("Os campos senha e confirmação de senha estão com dados diferentes");
            }
        }
        else{msgErroCad.setText("Esse endereço de e-mail já existe no sistema, favor cadastrar um enedreço diferente");}



    }

    public void voltar_cad_user(ActionEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("TelaDeLogin.fxml")));
            Parent root = loader.load();
            Controller_Tela_Login controller = loader.getController();
            Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            //controller.setPreviousScene(primaryStage.getScene());
            primaryStage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();


        }
    }
}
