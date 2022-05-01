package java_06_nga_profi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginViewController {
	@FXML
	private TextField txtEmri;
	
	@FXML
	private TextField txtMbiemri;
	
	@FXML
	private void confirmEventHandler(ActionEvent e) {
		System.out.println(this.txtEmri.getText());
	}
	
	@FXML
	private void clearEventHandler(ActionEvent e) {
		System.out.println("Clear");
	}
}