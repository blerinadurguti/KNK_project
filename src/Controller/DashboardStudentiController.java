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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DashboardStudentiController implements Initializable{

	private Stage stage;
	private Scene scene;
	
	 @FXML
	    private ChoiceBox<String> ChBoxLang;
	    private String[] Gjuha = {"Shqip","Anglisht"};

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			ChBoxLang.getItems().addAll(this.Gjuha);	
		}

    @FXML
    private TextField txtSearch;

    @FXML
    void Ballina(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/views/DashboardStudenti.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void Orari(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/views/OrariStudenti.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void Profili(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/views/ProfiliStudenti.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void Search(ActionEvent event) {

    }

    @FXML
    void Shkyqu(ActionEvent event) throws IOException {
    	  Parent root = FXMLLoader.load(getClass().getResource("/views/log_in.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
    }

}
