package Easy_Task.core;

import Easy_Task.dao.ConnectionFactory;
import Easy_Task.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sessao {
    public static User getUsuarioSessao() {
        return usuarioSessao;
    }

    private static User usuarioSessao;


    public static boolean validarLogin (String email, String senha){
        boolean validacaoLogin = false;
        try {
        Connection conn = (new ConnectionFactory()).getConnection();
        PreparedStatement p = conn.prepareStatement("select usuarioEmail, usuarioSenha from usuarios where usuarioEmail = ? and usuarioSenha = ?");
        p.setString(1, email);
        p.setString(2, senha);
            ResultSet rs = p.executeQuery();

            if (rs.next()) {
                email = rs.getString("usuarioEmail");
                senha = rs.getString("usuarioSenha");
                validacaoLogin = true;

            }
            else {
                validacaoLogin = false;

            }
            p.close();
            conn.close();

        }catch(Exception e) {
            e.printStackTrace();
        }
        return validacaoLogin;

    }

    public static void fazerLogin(User user) {

        Sessao.usuarioSessao = user;
        }


    public static void deslogar() {
        Sessao.usuarioSessao = null;

    }
    public static boolean temUsarioLogado () {
        return usuarioSessao != null;

    }


}
