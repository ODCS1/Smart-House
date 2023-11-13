package controllers;
import java.io.IOException;

import estado_lampadas.EstadoLampMaster;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MasterController {
    
    private Stage stage;
    private Scene scene;

    @FXML
    private Label myLabel1, myLabel2;
    @FXML
    private CheckBox myCheckBox1, myCheckBox2;
    @FXML
    private ImageView myImageView1, myImageView2;

    Image myImage1_OFF = new Image(getClass().getResourceAsStream("/img/light-bulb.png"));
    Image myImage1_ON = new Image(getClass().getResourceAsStream("/img/light-bulb-on.png"));
    
    Image myImage2_OFF = new Image(getClass().getResourceAsStream("/img/light-bulb.png"));
    Image myImage2_ON = new Image(getClass().getResourceAsStream("/img/light-bulb-on.png"));
    
    @FXML
    public void change1(ActionEvent event) {
        if(myCheckBox1.isSelected()) {
            myLabel1.setText("ON");
            myImageView1.setImage(myImage1_ON);
            EstadoLampMaster.setCheckedMaster1(true);
        } else {
            myLabel1.setText("OFF");
            myImageView1.setImage(myImage1_OFF);
            EstadoLampMaster.setCheckedMaster1(false);
        }
    }

    @FXML
    public void change2(ActionEvent event) {
        if(myCheckBox2.isSelected()) {
            myLabel2.setText("ON");
            myImageView2.setImage(myImage2_ON);
            EstadoLampMaster.setCheckedMaster2(true); 
        } else {
            myLabel2.setText("OFF");
            myImageView2.setImage(myImage2_OFF);
            EstadoLampMaster.setCheckedMaster2(false);
        }
    }

    @FXML
    public void initialize() {
        myCheckBox1.setSelected(EstadoLampMaster.isCheckedMaster1());
        if (myCheckBox1.isSelected()) {
            myLabel1.setText("ON");
            myImageView1.setImage(myImage1_ON);
        } else {
            myLabel1.setText("OFF");
            myImageView1.setImage(myImage1_OFF);
        }
    
        myCheckBox2.setSelected(EstadoLampMaster.isCheckedMaster2());
        if (myCheckBox2.isSelected()) {
            myLabel2.setText("ON");
            myImageView2.setImage(myImage2_ON);
        } else {
            myLabel2.setText("OFF");
            myImageView2.setImage(myImage2_OFF);
        }
    }

    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaLogin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaMain.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void MostrarLuzSala(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaSala.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void MostrarLuzMaster(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaMaster.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void MostrarLuzJardim(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaJardim.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void MostrarLuzQuarto1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaQuarto1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void MostrarLuzQuarto2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaQuarto2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSeg(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaSeguranca.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void MostrarLuzBanheiro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaBanheiro.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
