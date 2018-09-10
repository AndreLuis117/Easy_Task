package Easy_Task.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Easy_Task.dao.ConnectionFactory;
import Easy_Task.entity.User;
import Easy_Task.core.Sessao;

public class UserDAO {

    // Insere um Usuário
    public void insert(User user) {
        try {
            // Cria a conexãoo com o banco de dados
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement p =
                    conn.prepareStatement("insert into usuarios(usuarioNome,usuarioSenha,usuarioSobrenome, usuarioEmail) values(?, ?, ?, ?) ");
            p.setString(1, user.getName());
            p.setString(2, user.getPassword());
            p.setString(3, user.getLastname());
            p.setString(4, user.getEmail());

            p.execute();
            p.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    // Mï¿½todo para atualizar
    public void updateUser (User user) {
        try {
            // Cria a conexão com o banco de dados
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement p =
                    conn.prepareStatement("update usuarios set usuarioNome = ?, usuarioSobrenome = ?, usuarioSenha = ?, usuarioEmail = ? where usuarioId = 5");

            p.setString(1, user.getName());
            p.setString(2, user.getLastname());
            p.setString(3, user.getPassword());
            p.setString(4, user.getEmail());

            p.execute();
            p.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

    }



    // Método para excluir um usuário pelo ID
    public void deleteUser(long aux) {
        try {
            // Cria a conexï¿½o com o banco de dados
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement p =
                    conn.prepareStatement("delete from usuarios where usuarioId = ?");

            p.setLong(1, aux);
            p.execute();
            p.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }



    // Exclui todos os registros da Tabela
    public void deleteAll() {
        try {
            // Cria a conexï¿½o com o banco de dados
            Connection conn = (new ConnectionFactory()).getConnection();

            Statement stat = conn.createStatement();
            stat.execute("delete from user");
            // Fecha conexï¿½o com o banco de dados
            stat.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void selectNome(String email) {
        try {
            // Cria a conexão com o banco de dados
            Connection conn = (new ConnectionFactory()).getConnection();

            //String consulta = " select usuarioNome from usuarios where usuarioEmail = '?' ";
            PreparedStatement p = conn.prepareStatement("select usuarioNome from usuarios where usuarioEmail = ? ");
            p.setString(1, email);

            ResultSet rs = p.executeQuery();
            rs.next();
            String result = rs.getString("usuarioNome");

            System.out.println(result);
            p.close();
            // Fecha conexão com o banco de dados
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }





}
