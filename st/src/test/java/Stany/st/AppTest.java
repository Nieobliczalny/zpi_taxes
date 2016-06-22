package Stany.st;

import java.io.FileNotFoundException;
import java.util.List;

import junit.framework.TestCase;

public class AppTest extends TestCase {
	private static final String LISTA_STANOW_PATH = "lista_stanow_test.txt";
	private static final String LISTA_PRODUKTOW_PATH = "produkty_test.txt";
	
	public void setUp() {
		
	}
	
	public void testReadTaxesFromFile() {
		String[] productNames = {"Apple", "Apple Cake", "Lenovo Y700-17", "Geodon", "Katya Mono Printed Sleeveless Shift Dress"};
		int[] prices = {2, 11, 3753, 25};
		String[] categories = {"Groceries", "Prepared food", "Other", "Clothing"};
		
		try {
			List<Produkt> productsList = App.readProductsFromFile(LISTA_PRODUKTOW_PATH);
			
			int index = 0;
			for (Produkt produkt : productsList) {
				String expectedProductName = productNames[index];
				int expectedPrice = prices[index];
				String expectedCategory = categories[index];
				
				assertEquals(expectedProductName, produkt.getNazwa());
				assertEquals(expectedPrice, produkt.getCena(), 0.01);
				assertEquals(expectedCategory, produkt.getKategoria());
				
				index += 1;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void testReadProductsFromFile() {
		
	}

}
