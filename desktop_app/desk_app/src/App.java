import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    
    public void start(Stage primaryStage) throws IOException {
        try {
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("./telas/TelaLogin.fxml"));
            Parent root = loginLoader.load();
            Scene scene = new Scene(root);
            
            LoginController loginController = loginLoader.getController();
            TelaMainController scenes = new TelaMainController();
            loginController.telaMainController(scenes);

            scene.getStylesheets().add(getClass().getResource("./css/style.css").toExternalForm());

            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
