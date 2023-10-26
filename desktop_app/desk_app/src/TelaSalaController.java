import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class TelaSalaController {
    
    private Stage stage;
    private Scene scene;
    private boolean luzLigada = false;

    @FXML
    private RadioButton luz1;
    
    public void ligarLuz1(ActionEvent event) throws IOException {
        luzLigada = !luzLigada;
        if(luzLigada) {
            System.out.println("Luz 1 esta ligada");
        } else {
            System.out.println("Luz 1 esta desligada");
        }
        updateLuz1();
    }

    public void updateLuz1() {
        luz1.setSelected(luzLigada);
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./telas/TelaMain.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./telas/TelaLogin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
