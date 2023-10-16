// javac --module-path "C:\javafx-sdk-19\lib" --add-modules javafx.controls,javafx.fxml App.java
// java --module-path "C:\javafx-sdk-19\lib" --add-modules javafx.controls,javafx.fxml App
// java --module-path "C:\javafx-sdk-19\lib" --add-modules javafx.controls,javafx.fxml -cp "caminho/para/seu/projeto" seu.pacote.App


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public void start(Stage primaryStage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("./telas/TelaLogin.fxml"));
            Scene tela = new Scene(root);
            
            tela.getStylesheets().add(getClass().getResource("./css/style.css").toExternalForm());
            
            primaryStage.setResizable(false);
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
