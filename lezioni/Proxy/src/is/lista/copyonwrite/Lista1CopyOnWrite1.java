package Proxy.src.is.lista.copyonwrite;

import Proxy.src.is.lista.Lista1;

public class Lista1CopyOnWrite1<E> implements Lista1<E> {

	private static final class ReferenceCounter<E> {
		private int counter;
		private Lista1<E> lista;

		public ReferenceCounter(Lista1<E> l) {
			counter = 1;
			lista = l;
		}

		public Lista1<E> getLista() {
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
			ReferenceCounter<E> cr = new ReferenceCounter<E>(lista.copia());
			counter--;
			return cr;
		}
	}

	private ReferenceCounter<E> ref;

	public Lista1CopyOnWrite1(Lista1<E> l) {
		if (l instanceof Lista1CopyOnWrite1)
			throw new IllegalArgumentException("Proxy multipli non ammessi");
		ref = new ReferenceCounter<E>(l);
	}

	private Lista1CopyOnWrite1() {
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
	public Lista1<E> copia() {
		Lista1CopyOnWrite1<E> l = new Lista1CopyOnWrite1<E>();
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
