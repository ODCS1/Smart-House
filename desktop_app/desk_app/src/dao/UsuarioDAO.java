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
            sql = "SELECT * FROM sistema_casa.Clientes WHERE email_cliente = ? AND senha_cliente = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getEmail_cliente());
            ps.setString(2, usuario.getSenha_cliente());

            // Usa o SELECT para pesquisar na tabela de usuario se existe alguem com 
            // o email e senha digitado para logar
    
            rs = ps.executeQuery();
    
            if (rs.next()) {
                usuarioCompleto = new Usuario();
                usuarioCompleto.setNome_cliente(rs.getString("nome_cliente"));
                usuarioCompleto.setSobrenome_cliente(rs.getString("sobrenome_cliente"));
                usuarioCompleto.setEmail_cliente(rs.getString("email_cliente"));
                usuarioCompleto.setCpf_cliente(rs.getString("cpf_cliente"));

                //Seto o nome, email e cpf das respectivas colunas
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarioCompleto;
    }
}