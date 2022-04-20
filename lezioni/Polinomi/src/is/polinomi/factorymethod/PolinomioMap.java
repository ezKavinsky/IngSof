package Polinomi.src.is.polinomi.factorymethod;

import Polinomi.src.is.polinomi.Monomio;
import Polinomi.src.is.polinomi.Polinomio;

import java.util.Iterator;
import java.util.Map;

import static java.lang.Math.abs;

/**
 * 
 * Questa classe astratta funge da base per implementazioni del tipo definito
 * dall'interfaccia {@link Polinomio} che sfruttano una {@link Map} come
 * struttura dati per la memorizzazione dei singoli oggetti di tipo
 * {@link Monomio}. Le chiavi sono rappresentate dai gradi dei singoli monomi.
 * <p>
 * La classe {@link PolinomioMap} e' erede di {@link PolinomioAstratto}. Essa
 * introduce una variabile di istanza {@code protected} di tipo {@link Map} la
 * cui istanziazione e' delegata alle sotto classi. {@link PolinomioMap}
 * fornisce un'implementazione concreta dei metodi
 * {@link Polinomio#add(Monomio)}, {@link Polinomio#iterator()} e ridefinisce il
 * metodo {@link PolinomioAstratto#size()}.
 * </p>
 * <p>
 * {@link PolinomioMap} introduce il metodo factory {@code protected abstract}
 * {@link PolinomioMap#createMap()} che deve essere implementato dalle
 * sottoclassi.
 * </p>
 * 
 * @author Angelo Furfaro
 * 
 */
public abstract class PolinomioMap extends PolinomioAstratto {

	protected final Map<Integer, Monomio> map;

	public PolinomioMap() {
		map = createMap();
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public void add(Monomio m) {
		if (abs(m.getCoeff()) < Polinomio.EPS)
			return;
		Integer key = m.getGrado();
		Monomio m1 = map.get(key);
		if (m1 == null) {
			map.put(key, m);
			return;
		}
		Monomio ris = m1.add(m);
		if (abs(ris.getCoeff()) < Polinomio.EPS)
			map.remove(key);
		else
			map.put(key, ris);

	}

	@Override
	public Iterator<Monomio> iterator() {
		return new PIterator();
	}

	/**
	 * 
	 * @return la mappa su cui memorizzare i monomi
	 */
	protected abstract Map<Integer, Monomio> createMap();

	class PIterator implements Iterator<Monomio> {
		private final Iterator<Monomio> it = map.values().iterator();

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