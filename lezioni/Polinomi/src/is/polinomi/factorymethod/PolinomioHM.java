package Polinomi.src.is.polinomi.factorymethod;

import Polinomi.src.is.polinomi.Monomio;
import Polinomi.src.is.polinomi.Polinomio;

import java.util.HashMap;


/**
 * Fornisce un'implementazione dell'interfaccia {@link Polinomio} basata su una
 * mappa di tipo {@link java.util.HashMap}.
 * 
 * @author Angelo Furfaro
 */
public class PolinomioHM extends PolinomioMap {

	@Override
	protected HashMap<Integer, Monomio> createMap() {

		return new HashMap<>();
	}

	@Override
	protected PolinomioHM create() {

		return new PolinomioHM();
	}
}
