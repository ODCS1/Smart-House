package dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;
import conexao.Conexao;
import entidade.Usuario;

public class UsuarioDAO {

    public Usuario verificarCredenciais(Usuario usuario) {
        Connection conn = Conexao.getConnection();
        Usuario usuarioCompleto = null;
    
        try {
            String callProcedure = "{CALL autenticar_usuario(?, ?)}";
            CallableStatement cs = (CallableStatement) conn.prepareCall(callProcedure);
            cs.setString(1, usuario.getEmail_cliente());
            cs.setString(2, usuario.getSenha_cliente());

            java.sql.ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                usuarioCompleto = new Usuario();
                usuarioCompleto.setNome_cliente(rs.getString("nome_cliente"));
                usuarioCompleto.setSobrenome_cliente(rs.getString("sobrenome_cliente"));
                usuarioCompleto.setEmail_cliente(rs.getString("email_cliente"));
                usuarioCompleto.setCpf_cliente(rs.getString("cpf_cliente"));
                
                return usuarioCompleto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
