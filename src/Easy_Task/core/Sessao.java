package Easy_Task.core;

import Easy_Task.dao.ConnectionFactory;
import Easy_Task.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sessao {
    public static User getUsuario() {
        return usuario;
    }

    private static User usuario;


    public static boolean validarLogin (String email, String senha){
        boolean validado = false;
        try {
        Connection conn = (new ConnectionFactory()).getConnection();
        PreparedStatement p = conn.prepareStatement("select usuarioEmail, usuarioSenha from usuarios where usuarioEmail = ? and usuarioSenha = ?");
        p.setString(1, email);
        p.setString(2, senha);
            ResultSet rs = p.executeQuery();

            if (rs.next()) {
                email = rs.getString("usuarioNome");
                senha = rs.getString("usuarioSenha");
                validado = true;

            }
            else {
                System.out.println("Vc nao tem acesso ou seu usuário/senha são inválidos");

            }
            p.close();
            conn.close();

        }catch(Exception e) {
            e.printStackTrace();
        }
        return validado;

    }

    public static void fazerLogin(User user) {

        Sessao.usuario = user;
        }


    public static void deslogar() {
        Sessao.usuario = null;

    }
    public static boolean temUsarioLogado () {
        return usuario != null;

    }


}
