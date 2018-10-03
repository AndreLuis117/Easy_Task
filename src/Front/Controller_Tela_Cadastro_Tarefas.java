package Front;

import Easy_Task.dao.TaskDAO;
import Easy_Task.entity.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller_Tela_Cadastro_Tarefas implements Initializable {
    @FXML
    public TextField tarefaTitulo;
    @FXML
    public TextArea tarefaDescricao;
    @FXML
    public DatePicker tarefaData;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {


            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                }else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        tarefaData.setConverter(converter);
        tarefaData.setPromptText("dd/MM/yyyy");

        // configura o valor inicial
        tarefaData.setValue(LocalDate.now());



    }

    public void cadastrarTarefa(ActionEvent actionEvent) {

        TaskDAO taskDAO = new TaskDAO();
        Task task = new Task();
        System.out.println(tarefaTitulo.getText());
        task.setTaskName("Tarefa teste");
        task.setTaskDescription("Teste de trefa");
        try{
            //Transforma em java.sql.Date, que permite inserir no Banco de Dados.
            Date dataSql = Date.valueOf(tarefaData.getValue());
            task.setTaskDate(dataSql);
            System.out.println( dataSql);
        }catch (Exception e){
            e.printStackTrace();
        }
        taskDAO.insertTask(task);




    }
}
