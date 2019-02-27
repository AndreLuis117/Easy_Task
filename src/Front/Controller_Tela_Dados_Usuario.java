package front;

import back_end.core.Sessao;
import back_end.dao.UserDAO;
import back_end.entity.User;
import front.Controller_Tela_Home;
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

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller_Tela_Dados_Usuario implements Initializable {
    @FXML
    public TextField nomeField_2;
    @FXML
    public TextField sobrenomeField_2;
    @FXML
    public TextField emailField_2;
    @FXML
    public PasswordField senhaCadField_2;
    @FXML
    public PasswordField confSenhaField_2;
    @FXML
    public Label msgErroCad_2;

    private Scene previousScene;


    public void setPreviousScene(Scene scene) {
        this.previousScene = scene;
    }

    public void confirmarAlteracao(ActionEvent actionEvent) {
        UserDAO userDAO = new UserDAO();

        if (Sessao.getUsuarioSessao().getEmail().equals(emailField_2.getText())){
                if (senhaCadField_2.getText().equals(confSenhaField_2.getText())) {
                    User user = new User();
                    UserDAO userdao = new UserDAO();
                    user.setName(nomeField_2.getText());
                    user.setLastname(sobrenomeField_2.getText());
                    user.setPassword(senhaCadField_2.getText());
                    user.setEmail(Sessao.getUsuarioSessao().getEmail());
                    userDAO.updateUser(user);
                    msgErroCad_2.setText("Cadastro efetuado com suceesso");
                } else {
                    msgErroCad_2.setText("Os campos senha e confirmação de senha estão com dados diferentes");
                }


        }
        else {
            if (userDAO.validarEmail(emailField_2.getText()) == false) {
                if (senhaCadField_2.getText().equals(confSenhaField_2.getText())) {
                    User user = new User();
                    UserDAO userdao = new UserDAO();
                    user.setName(nomeField_2.getText());
                    user.setLastname(sobrenomeField_2.getText());
                    user.setEmail(emailField_2.getText());
                    user.setPassword(senhaCadField_2.getText());
                    userDAO.updateUser(user);
                    msgErroCad_2.setText("Cadastro efetuado com suceesso");
                } else {
                    msgErroCad_2.setText("Os campos senha e confirmação de senha estão com dados diferentes");
                }
            } else {
                msgErroCad_2.setText("Esse endereço de e-mail já existe no sistema, favor cadastrar um endereço diferente");
            }

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UserDAO USERdao =  new UserDAO();
        nomeField_2.setText(USERdao.selectNome(Sessao.getUsuarioSessao().getEmail()));
        sobrenomeField_2.setText(USERdao.selectSobrenome(Sessao.getUsuarioSessao().getEmail()));
        emailField_2.setText(Sessao.getUsuarioSessao().getEmail());
    }

    public void voltar_Dados_Usuario(ActionEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("TelaHome.fxml")));
            Parent root = loader.load();
            Controller_Tela_Home controller = loader.getController();
            Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            //controller.setPreviousScene(primaryStage.getScene());
            primaryStage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();


        }
    }
}
