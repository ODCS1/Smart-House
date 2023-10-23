import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsuarioDAO;
import entidade.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    
    private SceneController sceneController;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorMessageLabel;
    

    public void sceneController(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public void login(ActionEvent event) throws IOException, SQLException {
        String email = usernameField.getText();
        String senha = passwordField.getText();

        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ResultSet rsusuario = usuarioDAO.verificarCredenciais(usuario);
        
        if(rsusuario.next()) {
            switchToScene2(event);
        } else {
            errorMessageLabel.setText("Usuário ou senha estão incorretos");
        }
    }

    public void switchToScene2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("./telas/TelaMain.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
