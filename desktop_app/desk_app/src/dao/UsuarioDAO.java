package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;

public class UsuarioDAO {

    public boolean verificarCredenciais(String login, String password) {
        Connection connection = Conexao.getConnection();

        if(connection == null) {
            return false;
        }

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, password);

            rs = ps.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if(rs != null) rs.close();
                if(ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}