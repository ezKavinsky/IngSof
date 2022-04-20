package Proxy.src.is.lista.sicurezza;

import Proxy.src.is.lista.Lista1;

public class Lista1Sicura<E> implements Lista1<E> {

	private Lista1<E> lista;
	private PermessiUtente pu;

	public Lista1Sicura(Lista1<E> l, int nread, int nwrite) {
		lista = l;
		pu = new PermessiUtente(nread, nwrite);
	}

	private Lista1Sicura() {
	}
	
	//Nei seguenti metodi verifica se si hanno i permessi, altrimenti restituisce eccezione AccessoNonCosentito

	@Override
	public void aggiungi(int index, E dato) throws IndexOutOfBoundsException {
		if (pu.getNumeroScritture() == 0)
			throw new AccessoNonConsentitoException();
		pu.decrementaScritture();
		lista.aggiungi(index, dato);
	}

	@Override
	public void aggiungi(E dato) {
		if (pu.getNumeroScritture() == 0)
			throw new AccessoNonConsentitoException();
		pu.decrementaScritture();
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
	public Lista1<E> copia() {
		if (pu.getNumeroScritture() == 0)
			throw new AccessoNonConsentitoException();
		pu.decrementaScritture();
		Lista1Sicura<E> l = new Lista1Sicura<E>();
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
		pu.decrementaScritture();
		lista.rimuovi(index);
	}

	@Override
	public boolean rimuovi(E dato) {
		if (pu.getNumeroScritture() == 0)
			throw new AccessoNonConsentitoException();
		pu.decrementaScritture();
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
