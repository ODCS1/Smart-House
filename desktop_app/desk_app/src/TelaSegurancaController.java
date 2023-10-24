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

    public void updateUserInfo() {
        Usuario usuarioCompleto = Session.getCurrentUser();
        if (usuarioCompleto != null) {
            nomeCliente.setText("Nome: " + usuarioCompleto.getNome());
            emailCliente.setText("Email: " + usuarioCompleto.getEmail());
            cpfCliente.setText("Cpf: " + usuarioCompleto.getCpf());
        }

        // Esse metodo utiliza o session que esta armazenado o usuario atual
        // e atualiza os campos da tela de seguranca para as informacoes do usuario atual
        // ou seja, caso eu mude de usuario as informacoes mudaram tambem
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./telas/TelaMain.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        // Aqui apenas muda para a tela 2 que seria a principal
    }

    public void switchToSeg(ActionEvent event) throws IOException {
        telaMainController.switchToSeg(event);

        // Aqui apenas muda para a tela de seguranca, onde mostra as informacoes pessoais
    }

    @FXML
    public void initialize() {
        updateUserInfo();

        // Aqui carrega as informacoes do usuarios para que ela seja mostrada na tela de seguranca
    }
}
