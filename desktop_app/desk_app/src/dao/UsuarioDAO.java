package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import entidade.Usuario;

public class UsuarioDAO {

    public PreparedStatement ps;
    public ResultSet rs;
    public String sql;

    public ResultSet verificarCredenciais(Usuario usuario) {
        Connection connection = Conexao.getConnection();

        try {
            sql = "SELECT * FROM teste_bd.usuario WHERE email = ? AND senha = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());

            rs = ps.executeQuery();
            return rs;  

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }     
    }

    public ResultSet mostrarInfos(Usuario usuario) {
        Connection connection = Conexao.getConnection();

        try {
            sql = "SELECT nome, email, cpf FROM teste_bd.usuario WHERE email = ? AND senha = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());

            rs = ps.executeQuery();
            
            if(rs.next()) {
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCpf(rs.getString("cpf"));
        
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}