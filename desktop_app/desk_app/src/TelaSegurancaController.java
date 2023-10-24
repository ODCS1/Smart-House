import java.io.IOException;

import entidade.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TelaSegurancaController {
    private TelaMainController telaMainController;

    @FXML
    private Label nomeCliente;
    @FXML
    private Label emailCliente;
    @FXML
    private Label cpfCliente;
    
    public void telaMainController(TelaMainController telaMainController) {
        this.telaMainController = telaMainController;
    }

    public void setInfoClientes(Usuario usuario) {
        nomeCliente.setText(usuario.getNome());
        emailCliente.setText(usuario.getEmail());
        cpfCliente.setText(usuario.getCpf());
    }
    
    public void switchToScene2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("./telas/TelaMain.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSeg(ActionEvent event) throws IOException {
        telaMainController.switchToSeg(event);
    }
}
