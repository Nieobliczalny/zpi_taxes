package Stany.st;

import java.io.FileNotFoundException;
import java.util.List;

import junit.framework.TestCase;

public class AppTest extends TestCase {
	private static final String LISTA_STANOW_PATH = "lista_stanow_test.txt";
	private static final String LISTA_PRODUKTOW_PATH = "produkty_test.txt";
	
	public void setUp() {
		
	}
	
	public void testReadProductsFromFile() {
		String[] productNames = {"Apple", "Apple Cake", "Katya Mono Printed Sleeveless Shift Dress"};
		int[] prices = {2, 11, 25};
		String[] categories = {"Groceries", "Prepared food", "Clothing"};
		
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
	
	public void testReadTaxesFromFile() {
		Stan alabamaStan = new Stan("Alabama,4%,4%,4%,0%,4%,4%");
		Stan columbiaStan = new Stan("District of Columbia,5.75%,0%,10%,0%,0%,5.75%");
		Stan kansasStan = new Stan("Kansas,6.15%,6.15%,6.15%,6.15%,6.15%,6.15%");
		
		List<Stan> stanList = null;
		try {
			stanList = App.readTaxesFromFile(LISTA_STANOW_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		if (stanList != null) {
			assertEquals(alabamaStan, stanList.get(0));
			assertEquals(columbiaStan, stanList.get(1));
			assertEquals(kansasStan, stanList.get(2));
		}
	}
}
