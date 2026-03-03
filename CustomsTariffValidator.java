package hsCodes;

import java.util.HashMap;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CustomsTariffValidator {
	
	@FXML 
	private TextField tfTarifnummer;
	
	@FXML
	private Label lblErgebnis;
	
	private HashMap<String, String> kapitelVerzeichnis = new HashMap<>();
	
	@FXML
	private void initialize() {
		kapitelVerzeichnis.put("01", "Lebende Tiere");
		kapitelVerzeichnis.put("84", "Kernreaktoren, Kessel, Maschinen und mechanische Geräte; Teile davon");
		kapitelVerzeichnis.put("85", "Elektrische Maschinen, Apparate und Elektrotechnik, Teile davon");
		kapitelVerzeichnis.put("90", "Optische, fotografische oder medizinische Instrumente");
		
		Platform.runLater(() -> lblErgebnis.requestFocus());
	}

	@FXML
	public void handleCheckAction() {
		String eingabe = tfTarifnummer.getText();
		
		if (validate(eingabe)) {
			String code = eingabe.substring(0, 2);
			String info = kapitelVerzeichnis.getOrDefault(code, "Kapitel unbekannt.");
			
			lblErgebnis.setText(info);
			lblErgebnis.setStyle("-fx-text-fill: #2e7d32; -fx-font-weight: bold;");
		} else {
			lblErgebnis.setText("Fehler: Bitte 8 Ziffern eingeben.");
			lblErgebnis.setStyle("-fx-text-fill: #ff0000; -fx-font-weight: bold;");			
		}
	}
	
	
	public static boolean validate(String number) {
		return number != null && number.length() == 8 && number.matches("[0-9]+");
	}

}
