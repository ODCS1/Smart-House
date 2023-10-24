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
    
    public Usuario verificarCredenciais(Usuario usuario) {
        Connection connection = Conexao.getConnection();
        // Conexao com o banco de dados

        Usuario usuarioCompleto = null;
    
        try {
            sql = "SELECT * FROM teste_bd.usuario WHERE email = ? AND senha = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());

            // Usa o SELECT para pesquisar na tabela de usuario se existe alguem com 
            // o email e senha digitado para logar
    
            rs = ps.executeQuery();
    
            if (rs.next()) {
                usuarioCompleto = new Usuario();
                usuarioCompleto.setNome(rs.getString("nome"));
                usuarioCompleto.setEmail(rs.getString("email"));
                usuarioCompleto.setCpf(rs.getString("cpf"));

                //Seto o nome, email e cpf das respectivas colunas
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarioCompleto;
    }
}