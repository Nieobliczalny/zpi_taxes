package Stany.st;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Kategoria {
	
	public static ArrayList<String> readProductsFromCatogorie(String kategoria) throws FileNotFoundException
	{
		ArrayList<Produkt> temp = App.readProductsFromFile();
		ArrayList<String> temp2 = new ArrayList<String>();
		
		for (int i = 0; i < temp.size(); i++) {
			if(temp.get(i).getKategoria()==kategoria){
				temp2.add(temp.get(i).getNazwa());
				
			}
			
		}		
		return temp2;		
	}

}
