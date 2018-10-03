package Easy_Task.dao;

import Easy_Task.core.Sessao;
import Easy_Task.entity.Task;
import Easy_Task.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TaskDAO {

    public void insertTask(Task task) {
        try {
            // Cria a conexãoo com o banco de dados
            UserDAO USERdao = new UserDAO();

            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement p =
                    conn.prepareStatement("insert into tarefas(tarefaNome,tarefaDescricao,tarefaHora, usuarioId) values(?, ?, ?, ?) ");
            p.setString(1, task.getTaskName());
            p.setString(2, task.getTaskDescription());
            p.setString(3, task.getTaskHour());
            p.setLong(4, USERdao.selectId(Sessao.getUsuarioSessao().getEmail()));

            p.execute();
            p.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
