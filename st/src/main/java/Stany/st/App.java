package Stany.st;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final String PRODUKTY_PATH = "produkty.txt";
	public static final String LISTA_STANOW_PATH = "lista_stanow.txt";
   
    
	public static void main( String[] args ) throws FileNotFoundException
    {
    	ArrayList<Stan> listaStanow = new ArrayList<Stan>();		
		listaStanow = readTaxesFromFile(LISTA_STANOW_PATH);
		for(Stan s : listaStanow) System.out.println(s);
		ArrayList<Produkt> listaProduktow = new ArrayList<Produkt>();		
		listaProduktow = readProductsFromFile(PRODUKTY_PATH);
		for(Produkt p : listaProduktow) System.out.println(p);
    
    }
    
	public static ArrayList<Stan> readTaxesFromFile(String path) throws FileNotFoundException
	{
		ArrayList<Stan> temp = new ArrayList<Stan>();
		Scanner reader = new Scanner(new FileReader(LISTA_STANOW_PATH));
		while(reader.hasNextLine())
		{
			temp.add(new Stan(reader.nextLine()));
		}
		reader.close();
		return temp;		
	}
	public static ArrayList<Produkt> readProductsFromFile(String path) throws FileNotFoundException
	{
		ArrayList<Produkt> temp = new ArrayList<Produkt>();
		Scanner reader = new Scanner(new FileReader(PRODUKTY_PATH));
		while(reader.hasNextLine())
		{
			temp.add(new Produkt(reader.nextLine()));
		}
		reader.close();
		return temp;		
	}
}
