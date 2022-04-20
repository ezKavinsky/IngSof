package Factory.src.is.factorymap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class ElementHandler {
	/*
	 * Creator 
	 * - Dichiara il factory method (metodo newElement) che restituisce un
	 * oggetto della classe Product. 
	 * - Richiama il factory method per creare i Product.
	 */

	public MapElement createElement() throws IOException {

		/*
		 * Il metodo createElement fornisce il codice necessario per creare qualunque
		 * tipo di Product (MapElement). L�istanziazione del particolare elemento �
		 * delegata al metodo newElement, il quale � dichiarato astratto
		 */

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a label for the element: ");
		String label = reader.readLine();
		MapElement element = newElement();
		element.setLabel(label);
		return element;
	}

	public abstract MapElement newElement();

	public void paintElement(MapElement element) {
		System.out.println(element.getPaintingData());
	}

}
