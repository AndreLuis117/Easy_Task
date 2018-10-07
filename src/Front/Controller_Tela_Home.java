package Front;

import Easy_Task.core.Sessao;
import Easy_Task.dao.TaskDAO;
import Easy_Task.dao.UserDAO;
import Easy_Task.entity.Task;
import Easy_Task.entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller_Tela_Home implements Initializable {
    private Scene previousScene;
    @FXML
    public TableView taskView;
    @FXML
    public Button olaUser;


    public void setPreviousScene(Scene scene) {

        this.previousScene = scene;
    }

    private final ObservableList<Task> data =
            FXCollections.observableArrayList(

            );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        User user = new User();
        TaskDAO taskDAO = new TaskDAO();
        UserDAO userDAO = new UserDAO();
        data.clear();
        data.addAll(taskDAO.getAll());
        taskView.setItems(data);
        olaUser.setText("Olá " + userDAO.selectNome(Sessao.getUsuarioSessao().getEmail()) + "!");


    }

    public void addTask(ActionEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("TelaDeCadastroTarefas.fxml")));
            Parent root = loader.load();
            Controller_Tela_Cadastro_Tarefas controller = loader.getController();
            Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            //controller.setPreviousScene(primaryStage.getScene());
            primaryStage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();


        }
    }

    public void go_to_user(ActionEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("TelaDeDadosUsuario.fxml")));
            Parent root = loader.load();
            Controller_Tela_Dados_Usuario controller = loader.getController();
            Stage primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            //controller.setPreviousScene(primaryStage.getScene());
            primaryStage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();


        }
    }
}


