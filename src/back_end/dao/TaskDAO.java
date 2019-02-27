package back_end.dao;

import back_end.core.Sessao;
import back_end.entity.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public void insertTask(Task task) {
        try {
            // Cria a conexãoo com o banco de dados
            UserDAO USERdao = new UserDAO();

            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement p =
                    conn.prepareStatement("insert into tarefas(tarefaNome,tarefaDescricao,tarefaHora, tarefaData, usuarioId, tarefaStatus) values(?, ?, ?, ?, ?, ?) ");
            p.setString(1, task.getTaskName());
            p.setString(2, task.getTaskDescription());
            p.setString(3, task.getTaskHour());
            p.setString(4,task.getTaskDate());
            p.setLong(5, USERdao.selectId(Sessao.getUsuarioSessao().getEmail()));
            p.setString(6, "A");

            p.execute();
            p.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(long id) {
        try {
            // Cria a conexão com o banco de dados
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement p =
                    conn.prepareStatement("delete from tarefas where tarefaId = ?");

            p.setLong(1, id);
            p.execute();
            p.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    public List<Task> getAll(){
            List<Task> list = new ArrayList<>();
            UserDAO userDAO = new UserDAO();

        //Obtem a conexao com o BD
        try

        {
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement p = conn.prepareStatement("select * from tarefas where usuarioId = ? and tarefaStatus = 'A'");
            p.setLong(1,userDAO.selectId(Sessao.getUsuarioSessao().getEmail()));
            // Executa a query
            ResultSet resultSet = p.executeQuery();

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


    public void update_task_status (Task task) {
        try {
            // Cria a conexão com o banco de dados
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement p =
                    conn.prepareStatement("update tarefas set tarefaStatus = ? where tarefaId = ?");
            p.setString(1,task.getTaskStatus());
            p.setLong(2, task.getTaskId());


            p.execute();
            p.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
