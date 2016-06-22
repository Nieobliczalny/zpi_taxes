package Stany.st;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Interface extends Application{
	private AnchorPane rootLayout;
	@FXML
	private ComboBox<String> productComboBox;
	@FXML
	private ComboBox<String> categoryComboBox;
	@FXML
	private ComboBox<String> stateComboBox;
	@FXML
	private TextField priceTextField;
	@FXML
	private Label podatekLabel;
	@FXML
	private Label priceCalcLabel;
	@FXML
	private Button calculateButton;

	ObservableList<Stan> stanList = FXCollections.observableArrayList();
	ObservableList<Produkt> produktList = FXCollections.observableArrayList();
	ObservableList<Kategoria> kategoriarList = FXCollections.observableArrayList();

	HashMap<String,ArrayList<String>> katProdukt = new HashMap<String, ArrayList<String>>();

	private Double cena;
	private Double podatek;

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader load = new FXMLLoader();
			load.setLocation(Interface.class.getResource("layout.fxml"));
			rootLayout = (AnchorPane) load.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void initialize() throws IOException, NoSuchFieldException, SecurityException {

		stanList.addAll(App.readTaxesFromFile());
		for (Stan s : stanList) {
			stateComboBox.getItems().add(s.getNazwa());
		}
		stateComboBox.setValue("Wybierz stan");

		produktList.addAll(App.readProductsFromFile());
		for (Produkt p : produktList) {
			katProdukt.put(p.getKategoria(),Kategoria.readProductsFromCatogorie(p.getKategoria()));
		}
		for (Map.Entry<String,ArrayList<String>> entry : katProdukt.entrySet())
		{
		   categoryComboBox.getItems().add(entry.getKey());
		}

		categoryComboBox.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String t, String t1) {
				productComboBox.getItems().clear();
				for (String s : katProdukt.get(t1)) {
					productComboBox.getItems().add(s);
				}
				updatePodatek(stateComboBox.valueProperty().get());
			}
	});

		productComboBox.setValue("Wybierz produkt");
		productComboBox.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String t, String t1) {
					for (Produkt p : produktList) {
						if (p.getNazwa().equals(t1)) {
							priceTextField.setText(String.valueOf(p.getCena()));
							cena = p.getCena();

						}
					}
					updatePodatek(stateComboBox.valueProperty().get());
				}
		});
		stateComboBox.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String t, String t1) {
					updatePodatek(t1);
				}
		});
		calculateButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				double cena = Double.valueOf(priceTextField.getText());
				priceCalcLabel.setText(String.valueOf(obliczPodatek(cena,podatek)));
			}
		});

		priceTextField.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				System.out.println(priceTextField.getText());

			}
		});
	}

	protected void updatePodatek(String nazwa)
	{
		for (Stan s : stanList) {
			if (s.getNazwa().equals(nazwa)) {
				String productName = productComboBox.valueProperty().get();
				Produkt produkt = null;
				for (Produkt p : produktList) {
					if (p.getNazwa().equals(productName)) produkt = p;
				}
				podatekLabel.setText(String.valueOf(s.getPodatek(produkt).getPodatek()));
				podatek = s.getPodatek(produkt).getPodatek();
			}
		}
	}

	public double obliczPodatek(double cena, double podatek) {
		return cena + (cena * (podatek * 0.01));
	}


	public static void main(String[] args) {
		launch(args);
	}

}
