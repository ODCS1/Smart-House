import java.io.IOException;

import controllers.LoginController;
import controllers.TelaMainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
    
    public void start(Stage primaryStage) throws IOException {
        try {
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/telas/TelaLogin.fxml"));
            Parent root = loginLoader.load();
            Scene scene = new Scene(root);


            LoginController loginController = loginLoader.getController();
            TelaMainController scenes = new TelaMainController();
            loginController.telaMainController(scenes);

            scene.getStylesheets().add(getClass().getResource("./css/style.css").toExternalForm());

            primaryStage.setResizable(false);

            primaryStage.setTitle("Smart Model House");
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("./img/java-icon.png")));
            
            primaryStage.setScene(scene);
            primaryStage.show();

            // Essa parte é responsavel por carregar a tela de login junto com o seu css
            // e mostrar ele. Utiliza ela ja no App.java, pois é a primeira coisa que deve aparecer
            // quando o usuario rodar o aplicativo.
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
