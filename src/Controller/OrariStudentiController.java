package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Oraret;
import processor.CarryProcessor;
import processor.GjuhaProcessor;
import repository.OraretRepository;

public class OrariStudentiController implements Initializable{

	private CarryProcessor c;
	
	private Stage stage;
	private Scene scene;
	
	private ObservableList<Oraret> oblist = FXCollections.observableArrayList();
	private OraretRepository oraretRepository = new OraretRepository();
	
	  @FXML
	    private Label lblEmri;
	
	  @FXML
	    private TableView<Oraret> OrariTV;

	    @FXML
	    private TableColumn<Oraret, String> col_dita;

	    @FXML
	    private TableColumn<Oraret, String> col_kohaFillimit;

	    @FXML
	    private TableColumn<Oraret, String> col_lenda;

	    @FXML
	    private TableColumn<Oraret, String> col_profesori;

	    @FXML
	    private TableColumn<Oraret, String> col_salla;
	  
	    @FXML
	    private TableColumn<Oraret, String> col_l_u;    

	    
	  @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
	
		  this.col_dita.setCellValueFactory(new PropertyValueFactory<>("dita"));
		  this.col_kohaFillimit.setCellValueFactory(new PropertyValueFactory<>("kohaFillimit"));
		  this.col_lenda.setCellValueFactory(new PropertyValueFactory<>("lenda"));
		  this.col_salla.setCellValueFactory(new PropertyValueFactory<>("salla"));
		  this.col_profesori.setCellValueFactory(new PropertyValueFactory<>("profesori"));
		  this.col_l_u.setCellValueFactory(new PropertyValueFactory<>("l_u"));
		  
		  try {
			  oblist = oraretRepository.getDataS();
		  }catch(SQLException e) {
			  e.printStackTrace();
		  }
		  
		  OrariTV.setItems(oblist);
		  
		  try {
			c = new CarryProcessor();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  c.SetOrariStudenti(lblEmri);
		  
		}

	  
	 @FXML
	    void Ballina(ActionEvent event) throws IOException, SQLException {
		 GjuhaProcessor g = new GjuhaProcessor();
			Locale locale = new Locale(g.setGjuha());
			ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
			Parent root = FXMLLoader.load(getClass().getResource("/views/DashboardStudenti.fxml"),bundle);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    }

	  @FXML
	    void Orari(ActionEvent event) throws IOException, SQLException {
		  GjuhaProcessor g = new GjuhaProcessor();
			Locale locale = new Locale(g.setGjuha());
			ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
			Parent root = FXMLLoader.load(getClass().getResource("/views/OrariStudenti.fxml"),bundle);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    }

	  @FXML
	    void Profili(ActionEvent event) throws IOException, SQLException {
		  GjuhaProcessor g = new GjuhaProcessor();
			Locale locale = new Locale(g.setGjuha());
			ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
			Parent root = FXMLLoader.load(getClass().getResource("/views/ProfiliStudenti.fxml"),bundle);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    }

	  @FXML
	    void Shkyqu(ActionEvent event) throws IOException, SQLException {
		  GjuhaProcessor g = new GjuhaProcessor();
			Locale locale = new Locale(g.setGjuha());
			ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
			Parent root = FXMLLoader.load(getClass().getResource("/views/log_in.fxml"),bundle);
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
	    }

}
