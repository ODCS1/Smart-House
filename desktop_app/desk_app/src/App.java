// javac --module-path "C:\path\to\javafx-sdk-<version>\lib" --add-modules javafx.controls,javafx.fxml App.java
// java --module-path "C:\Program Files\Java\javafx-sdk-21\lib" --add-modules javafx.controls,javafx.fxml App


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public void start(Stage primaryStage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
            Scene tela = new Scene(root);
            
            tela.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

            primaryStage.setScene(tela);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
