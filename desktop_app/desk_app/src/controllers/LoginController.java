package controllers;
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

        Usuario usuario = new Usuario();
        usuario.setEmail_cliente(email);
        usuario.setSenha_cliente(senha);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioCompleto = usuarioDAO.verificarCredenciais(usuario);

        if (usuarioCompleto != null) {
            Session.setCurrentUser(usuarioCompleto);
            System.out.println(usuarioCompleto.getPacote());
            telaMainController.switchToScene2(event);
        } else {
            errorMessageLabel.setText("Usuário ou senha estão incorretos");
        }
    }
}
