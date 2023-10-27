import java.io.IOException;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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

    private BooleanProperty luz1Ligada = new SimpleBooleanProperty(false);
    private BooleanProperty luz2Ligada = new SimpleBooleanProperty(false);
    private BooleanProperty luz3Ligada = new SimpleBooleanProperty(false);

    @FXML
    private RadioButton luz1;
    @FXML
    private RadioButton luz2;
    @FXML
    private RadioButton luz3;

    public void initialize() {

        luz1.setSelected(luz1Ligada.get());
        luz2.setSelected(luz2Ligada.get());
        luz3.setSelected(luz3Ligada.get());
    }

    public void ligarLuz1(ActionEvent event) throws IOException {
        luz1Ligada.set(!luz1Ligada.get());
        if (luz1Ligada.get()) {
            System.out.println("Luz 1 ON");
        } else {
            System.out.println("Luz 1 OFF");
        }
    }

    public void ligarLuz2(ActionEvent event) throws IOException {
        luz2Ligada.set(!luz2Ligada.get());
        if (luz2Ligada.get()) {
            System.out.println("Luz 2 ON");
        } else {
            System.out.println("Luz 2 OFF");
        }
    }

    public void ligarLuz3(ActionEvent event) throws IOException {
        luz3Ligada.set(!luz3Ligada.get());
        if (luz3Ligada.get()) {
            System.out.println("Luz 3 ON");
        } else {
            System.out.println("Luz 3 OFF");
        }
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

