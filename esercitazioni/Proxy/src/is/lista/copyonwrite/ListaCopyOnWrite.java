package Proxy.src.is.lista.copyonwrite;

import Proxy.src.is.lista.Lista;

public class ListaCopyOnWrite<E> implements Lista<E> {

	//Inner class per definire il ref
	private static final class ReferenceCounter<E> {
		private int counter;
		private Lista<E> lista;

		public ReferenceCounter(Lista<E> l) {
			counter = 1;
			lista = l;
		}

		public Lista<E> getLista() {
			return lista;
		}

		public synchronized void decr() {
			counter--;
		}

		public synchronized void incr() {
			counter++;
		}

		public synchronized ReferenceCounter<E> copyIfNecessary() {
			if (counter == 1) {
				return this;
			}
			ReferenceCounter<E> cr = new ReferenceCounter<E>((Lista<E>) lista.copia());
			counter--;
			return cr;
		}
	}

	private ReferenceCounter<E> ref;

	/*
	 * Si usa il costruttore che riceve una lista cos� che sia proxy per quella
	 * lista
	 */
	public ListaCopyOnWrite(Lista<E> l) {
		if (l instanceof Lista1CopyOnWrite1)
			throw new IllegalArgumentException("Proxy multipli non ammessi");
		ref = new ReferenceCounter<E>(l);
	}

	// Costruttore di default disabilitato --> private
	private ListaCopyOnWrite() {
	}

	@Override
	public int size() {
		return ref.getLista().size();
	}

	@Override
	public boolean contiene(E dato) {
		return ref.getLista().contiene(dato);
	}

	@Override
	public void aggiungi(int index, E dato) throws IndexOutOfBoundsException {
		ref = ref.copyIfNecessary();
		ref.getLista().aggiungi(index, dato);
	}

	@Override
	public void aggiungi(E dato) {
		ref = ref.copyIfNecessary();
		ref.getLista().aggiungi(dato);
	}

	@Override
	public void rimuovi(int index) throws IndexOutOfBoundsException {
		ref = ref.copyIfNecessary();
		ref.getLista().rimuovi(index);
	}

	@Override
	public boolean rimuovi(E dato) {
		ref = ref.copyIfNecessary();
		return ref.getLista().rimuovi(dato);
	}

	@Override
	public E dammiElemento(int index) throws IndexOutOfBoundsException {
		return ref.getLista().dammiElemento(index);
	}

	@Override
	public Lista<E> copia() {
		ListaCopyOnWrite<E> l = new ListaCopyOnWrite<E>();
		l.ref = this.ref;
		ref.incr();
		return l;
	}

	@Override
	protected void finalize() throws Throwable {

		try {
			ref.decr();
		} catch (Throwable t) {
			throw t;
		} finally {
			super.finalize();
		}
	}

	@Override
	public String toString() {
		return ref.getLista().toString();
	}
}
