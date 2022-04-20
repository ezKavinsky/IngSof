package Proxy.src.is.lista.impl;

import Proxy.src.is.lista.Lista1;

public class Lista1SuArray1<E> implements Lista1<E> {

	private Object[] elementi;
	private int size;

	public Lista1SuArray1(int capacita) {
		elementi = new Object[capacita];
	}

	public Lista1SuArray1(Lista1<E> l) {
		elementi = new Object[l.size()];
		size = l.size();
		for (int i = 0; i < l.size(); i++)
			elementi[i] = l.dammiElemento(i);
	}

	@Override
	public void aggiungi(int index, E dato) throws IndexOutOfBoundsException {
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException();
		if (size == elementi.length)// se l'array e' pieno occorre riallocare
			resize(ResizeType.GROW);
		// fai scorrere gli elementi da i a size-1 di un posto a destra (shift
		// destro)
		for (int j = size - 1; j >= index; j--)
			elementi[j + 1] = elementi[j];
		// inserisci dato
		elementi[index] = dato;
		size++; // conta questa aggiunta
	}

	@Override
	public void aggiungi(E dato) {
		aggiungi(size, dato);
	}

	@Override
	public boolean contiene(E dato) {
		// gestire il caso in cui dato==null
		for (int i = 0; i < size; ++i)
			if (elementi[i].equals(dato))
				return true;
		return false;
	}

	@Override
	public Lista1<E> copia() {
		Lista1SuArray1<E> l = new Lista1SuArray1<E>(this);
		return l;
	}

	@Override
	public void rimuovi(int index) throws IndexOutOfBoundsException {
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException();
		for (int i = index; i < size - 1; i++)
			elementi[i] = elementi[i + 1];
		size--;
		if (size <= elementi.length * 0.3)// soglia del 30%
			resize(ResizeType.SHRINK);
	}

	@Override
	public boolean rimuovi(E dato) {
		for (int i = 0; i < size; i++)
			if (elementi[i].equals(dato)) {
				rimuovi(i);
				return true;
			}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E dammiElemento(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException();
		return (E) elementi[index];
	}

	private enum ResizeType {
		GROW, SHRINK
	};

	private void resize(ResizeType tipo) {
		Object[] el;
		switch (tipo) {
		case GROW:
			el = new Object[size * 2];
			System.arraycopy(elementi, 0, el, 0, size);
			elementi = el;
			break;
		case SHRINK:
			el = new Object[elementi.length / 2];
			System.arraycopy(elementi, 0, el, 0, elementi.length / 2);
			elementi = el;
			break;
		default:
			break;
		}

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++)
			sb.append(" ").append(elementi[i]);
		sb.append(" ]");
		return sb.toString();
	}

}