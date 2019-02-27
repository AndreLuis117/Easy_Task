package front;

import back_end.core.Sessao;
import back_end.dao.TaskDAO;
import back_end.dao.UserDAO;
import back_end.entity.Task;
import back_end.entity.User;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller_Tela_Home implements Initializable {

    public TableView taskView;
    @FXML
    public Button olaUser;



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
        addButtonDelete();
        addButtonFinish();

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


    //Esse método adiciona o botão para finalizar tarefas na tela Home
    private void addButtonFinish() {
        TableColumn<Task, Void> colBtn = new TableColumn("Ação");

        Callback<TableColumn<Task, Void>, TableCell<Task, Void>> cellFactory = new Callback<TableColumn<Task, Void>, TableCell<Task, Void>>() {
            @Override
            public TableCell<Task, Void> call(final TableColumn<Task, Void> param) {
                final TableCell<Task, Void> cell = new TableCell<Task, Void>() {

                    private final Button btn = new Button("Finalizar");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Task task = new Task();
                            TaskDAO taskdao = new TaskDAO();
                            Task data = getTableView().getItems().get(getIndex());
                            task.setTaskId(data.getTaskId());
                            task.setTaskStatus("F");
                            taskdao.update_task_status(task);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        taskView.getColumns().add(colBtn);

    }

    //Esse método adiciona o botão para deletar tarefas na tela Home
    private void addButtonDelete() {
        TableColumn<Task, Void> colBtn = new TableColumn("Ação");

        Callback<TableColumn<Task, Void>, TableCell<Task, Void>> cellFactory = new Callback<TableColumn<Task, Void>, TableCell<Task, Void>>() {
            @Override
            public TableCell<Task, Void> call(final TableColumn<Task, Void> param) {
                final TableCell<Task, Void> cell = new TableCell<Task, Void>() {

                    private final Button btn = new Button("Excluir");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Task task = new Task();
                            TaskDAO taskdao = new TaskDAO();
                            Task data = getTableView().getItems().get(getIndex());
                            task.setTaskId(data.getTaskId());
                            task.setTaskStatus("E");
                            taskdao.update_task_status(task);
                            try {
                                FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("TelaHome.fxml")));
                                Parent root = loader.load();
                                Controller_Tela_Home controller = loader.getController();
                                Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                primaryStage.setScene(new Scene(root));
                            } catch (Exception e) {
                                e.printStackTrace();


                            }
                        });
                }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        taskView.getColumns().add(colBtn);

    }

}


