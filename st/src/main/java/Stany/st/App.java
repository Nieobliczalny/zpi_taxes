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
    	ArrayList<Stan> lista = new ArrayList<Stan>();		
		lista = readTextFile();		
    }
    
	public static ArrayList<Stan> readTextFile() throws FileNotFoundException
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
}
