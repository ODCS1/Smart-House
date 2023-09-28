// javac --module-path "C:\path\to\javafx-sdk-<version>\lib" --add-modules javafx.controls,javafx.fxml App.java
// java --module-path "C:\path\to\javafx-sdk-<version>\lib" --add-modules javafx.controls,javafx.fxml App


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaLogin.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);

        tela.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setTitle("Login");
        primaryStage.setScene(tela);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
