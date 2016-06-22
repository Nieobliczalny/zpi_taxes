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
	private Label priceLabel;
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
	ArrayList<String> productsFromCategory;
	
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

		stanList.addAll(App.readTaxesFromFile(App.LISTA_STANOW_PATH));
		for (Stan s : stanList) {
			stateComboBox.getItems().add(s.getNazwa());
		}
		stateComboBox.setValue("Wybierz stan");
		
		produktList.addAll(App.readProductsFromFile(App.PRODUKTY_PATH));
		for (Produkt p : produktList) {
			katProdukt.put(p.getKategoria(),Kategoria.readProductsFromCatogorie(p.getKategoria()));
			//productComboBox.getItems().add(p.getNazwa());
		}
		for (String s : Kategoria.readProductsFromCatogorie("Clothing")) {
			System.out.println(s);
		}
		
		for (Map.Entry<String,ArrayList<String>> entry : katProdukt.entrySet())
		{
		   categoryComboBox.getItems().add(entry.getKey());
//		   for (String p : entry.getValue()) {
//			   System.out.println(p);
//			   productComboBox.getItems().add(p);
//		   }
		}

		categoryComboBox.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String t, String t1) {
				productComboBox.getItems().clear();
				for (String s : katProdukt.get(t1)) {
					productComboBox.getItems().add(s);
				}
//				for (Produkt p : produktList){
//					   System.out.println("t1 " + t1);
//					System.out.println(p.getKategoria());
//						if (t1.equals(p.getKategoria())) {
//							   productComboBox.getItems().add(p.getNazwa());
//						}
//				   }
			}
	});
		
		productComboBox.setValue("Wybierz produkt");
		productComboBox.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String t, String t1) {
					for (Produkt p : produktList) {
						if (p.getNazwa().equals(t1)) {
							priceLabel.setText(String.valueOf(p.getCena()));
							cena = p.getCena();

						}
					}
				}
		});
		stateComboBox.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String t, String t1) {
					for (Stan s : stanList) {
						if (s.getNazwa().equals(t1)) {
							podatekLabel.setText(String.valueOf(s.getPodatek()));
							podatek = s.getPodatek();
						}
					}
				}
		});
		calculateButton.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				priceCalcLabel.setText(String.valueOf(cena+(cena*(podatek*0.01))));
			}
		});
	}
	
	
	

	public static void main(String[] args) {
		launch(args);
	}

}
