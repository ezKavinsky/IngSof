package Polinomi.src.is.polinomi.factorymethod;
import Polinomi.src.is.polinomi.Monomio;

import java.util.Map;
import java.util.TreeMap;


/**
 * Fornisce un'implementazione dell'interfaccia {@link is.polinomi.Polinomio} basata su una
 * mappa di tipo {@link java.util.TreeMap}.
 * 
 * @author Angelo Furfaro
 * 
 */
public class PolinomioTM extends PolinomioMap {

	@Override
	protected PolinomioTM create() {

		return new PolinomioTM();
	}

	@Override
	protected Map<Integer, Monomio> createMap() {

		return new TreeMap<>();
	}

}
