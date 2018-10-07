package Easy_Task.dao;

import Easy_Task.core.Sessao;
import Easy_Task.entity.Task;
import Easy_Task.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public void insertTask(Task task) {
        try {
            // Cria a conexãoo com o banco de dados
            UserDAO USERdao = new UserDAO();

            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement p =
                    conn.prepareStatement("insert into tarefas(tarefaNome,tarefaDescricao,tarefaHora, tarefaData, usuarioId) values(?, ?, ?, ?, ?) ");
            p.setString(1, task.getTaskName());
            p.setString(2, task.getTaskDescription());
            p.setString(3, task.getTaskHour());
            p.setString(4,task.getTaskDate());
            p.setLong(5, USERdao.selectId(Sessao.getUsuarioSessao().getEmail()));

            p.execute();
            p.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public List<Task> getAll(){
        List<Task> list = new ArrayList<>();

        //Obtem a conexao com o BD
        try(
                Connection conn = (new ConnectionFactory()).getConnection();
                Statement statement = conn.createStatement()
        ){
            // Executa a query
            ResultSet resultSet = statement.executeQuery("select * from tarefas where usuarioId = 23");

            // Para cada resultado da query
            while(resultSet.next()){
                // Cria um novo objeto usuario
                Task task = new Task();

                // Obtem os valores dos campos, deve ser na mesma ordem informada na query
                task.setTaskId(resultSet.getLong(1));
                task.setTaskName(resultSet.getString(2));
                task.setTaskDescription(resultSet.getString(3));
                task.setTaskDate(resultSet.getString(4));
                task.setTaskHour(resultSet.getString(5));



                // Adiciona na lista
                list.add(task);
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return list;
    }

}
