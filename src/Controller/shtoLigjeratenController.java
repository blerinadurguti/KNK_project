package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class shtoLigjeratenController {

	private Stage stage;
	private Scene scene;
	
    @FXML
    void Ballina(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/views/Dashboard.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void Orari(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/views/Orari.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void Profili(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/views/Profili.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void Shkyqu(ActionEvent event) throws IOException {
    	  Parent root = FXMLLoader.load(getClass().getResource("/views/log_in.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
    }

    @FXML
	void ShtoLigjeraten(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/views/shtoLigjeraten.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}