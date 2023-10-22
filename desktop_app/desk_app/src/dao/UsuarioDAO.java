package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import entidade.Usuario;

public class UsuarioDAO {

    public boolean verificarCredenciais(String email, String senha) {
        Connection connection = Conexao.getConnection();

        if(connection == null) {
            return false;
        }

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM teste_bd.usuario WHERE email = ? AND senha = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);

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

    public String mostrarInfos(String email, String senha) {
        Connection connection = Conexao.getConnection();
        if(connection == null) {
            return null;
        }

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT nome, email, cpf FROM teste_bd.usuario WHERE email = ? AND senha = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);

            rs = ps.executeQuery();
            
            if(rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCpf(rs.getString("cpf"));
                
                // String nome = rs.getString("nome");
                // String emailResult = rs.getString("email");
                // String cpf = rs.getString("cpf");
                // return "Nome: " + nome + "\nEmail: " + emailResult + "\nCPF: " + cpf;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) rs.close();
                if(ps != null) ps.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}