import java.io.IOException;
import java.lang.ProcessHandle.Info;

import com.mysql.cj.jdbc.SuspendableXAConnection;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneController {
    private Stage stage;
    private Scene scene;
    
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorMessageLabel;
    @FXML
    private Label nomeCliente;
    @FXML
    private Label emailCliente;
    @FXML
    private Label cpfCliente;

    public void switchToScene1(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("./telas/TelaLogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToScene2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("./telas/TelaMain.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToCozinha(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("./telas/TelaCozinha.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToSalaDeTv(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("./telas/TelaSala.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToQuartos(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("./telas/TelaQuartos.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToSeg(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./telas/TelaSeguranca.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        exibirInformacoesDoCliente(event);
        stage.show();
    }

    public void login(ActionEvent event) throws IOException {
        String email = usernameField.getText();
        String senha = passwordField.getText();

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        if(usuarioDAO.verificarCredenciais(email, senha)) {
            switchToScene2(event);
            System.out.println(usuarioDAO.mostrarInfos(email, senha));
        } else {
            errorMessageLabel.setText("Usuário ou senha estão incorretos");
        }
    }
    
    public void exibirInformacoesDoCliente(ActionEvent event) throws IOException {
        Usuario usuario = new Usuario();
        nomeCliente.setText(usuario.getNome());
        emailCliente.setText(usuario.getEmail());
        cpfCliente.setText(usuario.getCpf());
    }
}
