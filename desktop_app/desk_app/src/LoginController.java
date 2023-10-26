import java.io.IOException;
import java.sql.SQLException;

import dao.UsuarioDAO;
import entidade.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    private TelaMainController telaMainController;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorMessageLabel;

    public void telaMainController(TelaMainController telaMainController) {
        this.telaMainController = telaMainController;
    }

    public void login(ActionEvent event) throws IOException, SQLException {
        String email = usernameField.getText();
        String senha = passwordField.getText();

        // Essas duas Strings sao responsaveis por pegar as informacoes que o usuario digita
        // nos campos de email e senha.

        Usuario usuario = new Usuario();
        usuario.setEmail_cliente(email);
        usuario.setSenha_cliente(senha);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioCompleto = usuarioDAO.verificarCredenciais(usuario);

        // Apos verificar as credenciais usa o metodo setCurrentUser para guardar as informacoes do usuario atual
        // e em caso de sucesso, ou seja, se ele esta no banco de dados
        // trocara a cena para a tela principal. (switchToScene2(event);).

        if (usuarioCompleto != null) {
            Session.setCurrentUser(usuarioCompleto);
            telaMainController.switchToScene2(event);
        } else {
            errorMessageLabel.setText("Usuário ou senha estão incorretos");
        }
    }
}
