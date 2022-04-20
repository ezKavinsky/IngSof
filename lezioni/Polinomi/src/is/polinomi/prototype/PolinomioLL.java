package Polinomi.src.is.polinomi.prototype;

import Polinomi.src.is.polinomi.Monomio;
import Polinomi.src.is.polinomi.Polinomio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import static java.lang.Math.abs;

/**
 * 
 * Fornisce un'implementazione dell'interfaccia {@link Polinomio} basata su una
 * lista di tipo {@link java.util.LinkedList}
 * 
 * I monomi costituenti il polinomio sono memorizzati all'interno della lista
 * concatenata secondo l'ordinamento definito dalla classe Monomio.
 * 
 * @author Angelo Furfaro
 * 
 */
public class PolinomioLL extends PolinomioAstratto {

	private static PolinomioLL prototype;

	@Override
	protected synchronized PolinomioLL getPrototype() {
		if (prototype == null)
			prototype = new PolinomioLL();
		return prototype;
	}

	private LinkedList<Monomio> monomi = new LinkedList<>();

	@SuppressWarnings("unchecked")
	@Override
	public PolinomioLL clone() {

		PolinomioLL p = (PolinomioLL) super.clone();
		p.monomi = (LinkedList<Monomio>) monomi.clone();

		return p;
	}

	@Override
	public int size() {

		return monomi.size();
	}

	@Override
	public void add(Monomio m) {
		// se il coefficiente � da considerarsi zero non aggiunge il monomio
		if (abs(m.getCoeff()) < Polinomio.EPS)
			return;

		ListIterator<Monomio> it = monomi.listIterator();
		while (it.hasNext()) {// scandisce la lista alla ricerca della posizione
			// di inserimento
			Monomio m1 = it.next();
			// ha trovato un monomio dello stesso grado
			if (m1.compareTo(m) == 0) {

				// somma il monomio ricevuto con quello gi� presente
				Monomio m2 = m1.add(m);
				// se il risultato ha coefficiente diverso da "zero" sostituisce
				// il nuovo monomio con il vecchio altrimenti rimuove
				if (abs(m2.getCoeff()) >= Polinomio.EPS)
					it.set(m2);
				else
					it.remove();
				return;
			} else if (m1.compareTo(m) < 0) {
				// i monomi successivi hanno grado minore
				it.previous();
				break;
			}

		}
		it.add(m); // aggiunge il monomio nella posizione corrente
	}

	@Override
	public Iterator<Monomio> iterator() {

		return new PIterator();
	}

	private class PIterator implements Iterator<Monomio> {
		private final Iterator<Monomio> it = monomi.iterator();

		@Override
		public boolean hasNext() {

			return it.hasNext();
		}

		@Override
		public Monomio next() {

			return it.next();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

	}
}
