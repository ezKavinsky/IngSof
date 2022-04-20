package Polinomi.src.is.polinomi;


/**
 * Eccezione sollevata dal costruttore {@link Monomio#add(Monomio)} se il
 * l'oggetto {@link Monomio} ricevuto come parametro non ha lo stesso grado
 * dell'oggetto {@link Monomio} su cui il metodo e' stato invocato
 */
public class MonomiNonSimili extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2582281018167580314L;

	/**
	 * 
	 * @param g1
	 *            grado del primo monomio
	 * @param g2
	 *            grado del secondo monomio
	 */
	public MonomiNonSimili(int g1, int g2) {
		super("Monomi non simili: g1=" + g1 + " g2=" + g2);
	}
}
