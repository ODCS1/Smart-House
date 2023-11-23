package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import entidade.Usuario;

public class UsuarioDAO {

    public ResultSet rs;

    public Usuario verificarCredenciais(Usuario usuario) {
        Connection connection = Conexao.getConnection();
        Usuario usuarioCompleto = null;

        try {
            String sql = "SELECT c.id_cliente, c.nome_cliente, c.sobrenome_cliente, c.email_cliente, c.cpf_cliente, p.nome_pacote " +
                         "FROM sistema_casa.Clientes c " +
                         "JOIN sistema_casa.Compras cm ON c.id_cliente = cm.id_cliente " +
                         "JOIN sistema_casa.Pacotes p ON cm.id_pacote = p.id_pacote " +
                         "WHERE c.email_cliente = ? AND c.senha_cliente = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, usuario.getEmail_cliente());
                ps.setString(2, usuario.getSenha_cliente());

                rs = ps.executeQuery();

                if (rs.next()) {
                    usuarioCompleto = new Usuario();
                    usuarioCompleto.setId_cliente(rs.getInt("id_cliente"));
                    usuarioCompleto.setNome_cliente(rs.getString("nome_cliente"));
                    usuarioCompleto.setSobrenome_cliente(rs.getString("sobrenome_cliente"));
                    usuarioCompleto.setEmail_cliente(rs.getString("email_cliente"));
                    usuarioCompleto.setCpf_cliente(rs.getString("cpf_cliente"));
                    usuarioCompleto.setPacote(rs.getString("nome_pacote"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarioCompleto;
    }
}

