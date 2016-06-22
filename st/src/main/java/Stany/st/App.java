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
    public static void main( String[] args ) throws FileNotFoundException
    {
    	ArrayList<Stan> listaStanow = new ArrayList<Stan>();
		listaStanow = readTaxesFromFile();
		for(Stan s : listaStanow) System.out.println(s);
		ArrayList<Produkt> listaProduktow = new ArrayList<Produkt>();
		listaProduktow = readProductsFromFile();
		for(Produkt p : listaProduktow) System.out.println(p);
		//Przykładowe użycie obliczania listy stanów
		System.out.println(listaStanow.get(0).getPodatek(listaProduktow.get(20)).getPodatek());
    }

	public static ArrayList<Stan> readTaxesFromFile() throws FileNotFoundException
	{
		ArrayList<Stan> temp = new ArrayList<Stan>();
		Scanner reader = new Scanner(new FileReader("lista_stanow.txt"));
		while(reader.hasNextLine())
		{
			temp.add(new Stan(reader.nextLine()));
		}
		reader.close();
		return temp;
	}
	public static ArrayList<Produkt> readProductsFromFile() throws FileNotFoundException
	{
		ArrayList<Produkt> temp = new ArrayList<Produkt>();
		Scanner reader = new Scanner(new FileReader("produkty.txt"));
		while(reader.hasNextLine())
		{
			temp.add(new Produkt(reader.nextLine()));
		}
		reader.close();
		return temp;
	}
}
