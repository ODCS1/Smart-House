import java.io.IOException;
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
        stage.show();
    }
}
