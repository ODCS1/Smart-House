import java.io.IOException;

import dao.UsuarioDAO;
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
    private SceneController sceneController;
    private Stage stage;
    private Scene scene;

    @FXML
    private Label nomeCliente;
    @FXML
    private Label emailCliente;
    @FXML
    private Label cpfCliente;
    
    
    public void sceneController(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    // public void mostrarInformacoesClientes(Usuario usuario) {
    //     UsuarioDAO usuarioDAO = new UsuarioDAO();
    //     usuario = usuarioDAO.mostrarInfos(usuario);

    //     if(usuario != null) {
    //         nomeCliente.setText(usuario.getNome());
    //         emailCliente.setText(usuario.getEmail());
    //         cpfCliente.setText(usuario.getCpf());;
    //     } else {
    //         System.out.println("Nao achado");
    //     }
    // }
    
    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./telas/TelaMain.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSeg(ActionEvent event) throws IOException {
        nomeCliente.setText("ASSDASDASDASDADADASdaDA");
        Parent root = FXMLLoader.load(getClass().getResource("./telas/TelaSeguranca.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
