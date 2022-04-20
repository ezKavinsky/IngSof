package Proxy.src.is.lista;

import Proxy.src.is.lista.copyonwrite.Lista1CopyOnWrite1;
import Proxy.src.is.lista.impl.Lista1SuArray1;
import Proxy.src.is.lista.sicurezza.Lista1Sicura;

public class Liste {
	//FACTORY

	public static <E> Lista1<E> creaLista(int dim, boolean proxy) {
		// restituiamo una lista con o senza CopyOnwrite

		Lista1<E> miaLista = new Lista1SuArray1<E>(dim);
		if (!proxy)
			//Se non proxy crea una semplice ListaSuArray
			return miaLista;
		else
			//Se proxy wrappa la ListaSuArray con ListaCopyOnWrite
			return new Lista1CopyOnWrite1<E>(miaLista);
	}

	public static <E> Lista1<E> creaListaSicura(int dim, int nread, int nwrite, boolean cop) {
		//restituiamo una ListaSicura con o senza CopyOnWrite
		
		Lista1<E> miaLista = (Lista1<E>) new Lista1SuArray1<E>(dim);

		if (cop)
			//se copy on write aggiungo il proxy di copy on write
			miaLista = new Lista1CopyOnWrite1<E>(miaLista);

		return new Lista1Sicura<E>(miaLista, nread, nwrite);
	}

}
