package Proxy.src.is;

import Proxy.src.is.lista.Lista1;
import Proxy.src.is.lista.List;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final boolean copyOnWrite = true;
		Lista1<String> l = List.<String>creaListaSicura(1_000_000, 5, 5, copyOnWrite);

		l.aggiungi("1");
		l.rimuovi("1");
		l.aggiungi("35");
		l.aggiungi("21");
		l.aggiungi("41");
		//l.aggiungi("5");

		System.out.println(l);

		System.out.println("---------------");

		Lista1<String> l1 = List.<String>creaLista(10_000_000, copyOnWrite); // ampiezza 10milioni
		for (int i = 0; i < 1_000_000; i++)// popola la lista e la crea di un milione
			l1.aggiungi("Test:" + i);

		long startTime = System.currentTimeMillis(); // tempo corrente per misurare le performance

		for (int i = 0; i < 1_000; i++) {
			// Ogni volta, per mille volte, otteniamo una copia della lista
			Lista1<String> ln = l1.copia();

			// operazione di accesso in lettura
			ln.dammiElemento(4);

			/*
			 * Nell'1% dei casi aggiungi un elemento. Se il CopyOnWrite non � abilitato, si
			 * scatena una copia fisica della lista e non si condivide la rappresentazione
			 * della lista. Questa operazione fa perdere tempo.
			 * 
			 * Cambia copyOnWrite = true --> Miglioro?
			 * 
			 */

			if (Math.random() < 0.01)
				/*
				 * Quando il CopyOnWrite � attivo, si attiva la copia fisica solo quando si va
				 * ad effettuare un'operazione di modifica della lista
				 */
				ln.aggiungi("33");
		}
		System.out.println("\nTempo impiegato: " + (System.currentTimeMillis() - startTime));

	}

}
