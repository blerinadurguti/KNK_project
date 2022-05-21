package Controller;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import processor.CarryProcessor;
import processor.GjuhaProcessor;
import processor.Validations;
import repository.CarryRepository;
import repository.StudentRepository;

public class NdryshoFjalkaliminStudentiController implements Initializable{

	private CarryProcessor c;
	private Validations v = new Validations();
	private StudentRepository studentRepository = new StudentRepository();
	private CarryRepository carryRepository = new CarryRepository();
	private Alert a = new Alert(AlertType.NONE);
	
	private Stage stage;
	private Scene scene;
	
    @FXML
    private Label lblEmri;
	
    @FXML
    private Label lblError;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			c = new CarryProcessor();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c.setStudentiNdrysho(lblEmri);
		
	}

    
    
    @FXML
    private TextField txtFjalkalimiAktual;

    @FXML
    private TextField txtFjalkalimiIRi;

    @FXML
    private TextField txtKonfirmoFjalkalimin;

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
    void FSee(MouseEvent event) {

    }

    @FXML
    void KFSee(MouseEvent event) {

    }

    @FXML
    void NdryshoFjalkalimin(ActionEvent event) throws NoSuchAlgorithmException, SQLException, IOException {
    	
    	String oldPass = this.txtFjalkalimiAktual.getText();
    	String newPass = this.txtFjalkalimiIRi.getText();
    	String konPass = this.txtKonfirmoFjalkalimin.getText();
    	
    	if(!this.validateNotNull()) {
    		if(studentRepository.validateLogin(studentRepository.findUsernameById(carryRepository.getCarry().getCID()), oldPass)) {
    			if(v.MatchingPasswordsN(newPass, konPass)) {
    				
    				studentRepository.changePassword(newPass, carryRepository.getCarry().getCID());
    				
    				this.a.setAlertType(AlertType.CONFIRMATION);
        			this.a.setContentText("Password changed!");
        			this.a.show();
    				
        			Parent root = FXMLLoader.load(getClass().getResource("/views/NdryshoFjalkaliminStudenti.fxml"));
        			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        			scene = new Scene(root);
        			stage.setScene(scene);
        			stage.show();
    			}else {
    				this.lblError.setText("Passwords not matching!");
    			}
    		}else {
        		this.lblError.setText("Current Password wrong!");	
        		}
    	}else {
    		this.lblError.setText("All the fields must be filled!");
    	}
    	
    	
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

    private boolean validateNotNull() {
    	if(v.NullTextFields(txtKonfirmoFjalkalimin) || v.NullTextFields(txtFjalkalimiAktual) || v.NullTextFields(txtFjalkalimiIRi))
    	{    	
    	return true;
    	}else {
    		return false;
    	}
    }
    
}
