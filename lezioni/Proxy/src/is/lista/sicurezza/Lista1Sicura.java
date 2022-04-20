package is.lista.sicurezza;

import Proxy.src.is.lista.Lista;
import is.lista.Lista;

public class Lista1Sicura<E> implements Lista<E> {

	private Lista<E> lista;
	private PermessiUtente pu;

	public Lista1Sicura(Lista<E> l, int nread, int nwrite) {
		lista = l;
		pu = new PermessiUtente(nread, nwrite);
	}

	private Lista1Sicura() {
	}

	@Override
	public void aggiungi(int index, E dato) throws IndexOutOfBoundsException {
		if (pu.getNumeroScritture() == 0)
			throw new AccessoNonConsentitoException();
		pu.decrementaScriture();
		lista.aggiungi(index, dato);
	}

	@Override
	public void aggiungi(E dato) {
		if (pu.getNumeroScritture() == 0)
			throw new AccessoNonConsentitoException();
		pu.decrementaScriture();
		lista.aggiungi(dato);
	}

	@Override
	public boolean contiene(E dato) {
		if (pu.getNumeroLetture() == 0)
			throw new AccessoNonConsentitoException();
		pu.decrementaLetture();
		return lista.contiene(dato);
	}

	@Override
	public Lista<E> copia() {
		if (pu.getNumeroScritture() == 0)
			throw new AccessoNonConsentitoException();
		pu.decrementaScriture();
		is.lista.sicurezza.Lista1Sicura<E> l = new is.lista.sicurezza.Lista1Sicura<E>();
		l.lista = lista.copia();
		l.pu = pu;
		return l;
	}

	@Override
	public E dammiElemento(int index) throws IndexOutOfBoundsException {
		if (pu.getNumeroLetture() == 0)
			throw new AccessoNonConsentitoException();
		pu.decrementaLetture();
		return lista.dammiElemento(index);
	}

	@Override
	public void rimuovi(int index) throws IndexOutOfBoundsException {
		if (pu.getNumeroScritture() == 0)
			throw new AccessoNonConsentitoException();
		pu.decrementaScriture();
		lista.rimuovi(index);
	}

	@Override
	public boolean rimuovi(E dato) {
		if (pu.getNumeroScritture() == 0)
			throw new AccessoNonConsentitoException();
		pu.decrementaScriture();
		return lista.rimuovi(dato);
	}

	@Override
	public int size() {
		if (pu.getNumeroLetture() == 0)
			throw new AccessoNonConsentitoException();
		pu.decrementaLetture();
		return lista.size();
	}

	@Override
	public String toString() {
		if (pu.getNumeroLetture() == 0)
			throw new AccessoNonConsentitoException();
		pu.decrementaLetture();
		return lista.toString();
	}

}
