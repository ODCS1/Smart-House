package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
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
            String callProcedure = "{CALL autenticacao_usuario(?, ?, ?)}";
            CallableStatement cs = connection.prepareCall(callProcedure);
            cs.setString(1, usuario.getEmail_cliente());
            cs.setString(2, usuario.getSenha_cliente());
            cs.registerOutParameter(3, java.sql.Types.VARCHAR);

            rs = cs.executeQuery();

            if (rs.next()) {
                usuarioCompleto = new Usuario();
                usuarioCompleto.setNome_cliente(rs.getString("nome_cliente"));
                usuarioCompleto.setSobrenome_cliente(rs.getString("sobrenome_cliente"));
                usuarioCompleto.setEmail_cliente(rs.getString("email_cliente"));
                usuarioCompleto.setCpf_cliente(rs.getString("cpf_cliente"));
                
                String clientePacote = cs.getString(3);
                usuarioCompleto.setPacote(clientePacote);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarioCompleto;
    }
}
