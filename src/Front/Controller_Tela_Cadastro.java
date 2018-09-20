package Front;

import Easy_Task.dao.UserDAO;
import Easy_Task.entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
}
