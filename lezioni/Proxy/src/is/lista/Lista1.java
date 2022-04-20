package Proxy.src.is.lista;

public interface Lista1<E>{

	int size();
	
	boolean contiene(E dato);
	
	void aggiungi(int index,E dato)throws IndexOutOfBoundsException;
	
	void aggiungi(E dato);
	
	void rimuovi(int index)throws IndexOutOfBoundsException;
	
	boolean rimuovi(E dato);
	
	E dammiElemento(int index)throws IndexOutOfBoundsException;
	
	Lista1<E> copia();

}
