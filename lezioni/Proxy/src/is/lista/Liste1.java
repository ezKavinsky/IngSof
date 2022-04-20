package Proxy.src.is.lista;

import Proxy.src.is.lista.copyonwrite.Lista1CopyOnWrite1;
import Proxy.src.is.lista.impl.Lista1SuArray1;
import Proxy.src.is.lista.sicurezza.Lista1Sicura;

public class Liste1 {

	public static <E> Lista1<E> creaLista(int dim, boolean proxy) {
		Lista1<E> miaLista = new Lista1SuArray1<E>(dim);
		if (!proxy)
			return miaLista;
		else
			return new Lista1CopyOnWrite1<E>(miaLista);
	}

	public static <E> Lista1<E> creaListaSicura(int dim, int nread, int nwrite, boolean proxy) {
		Lista1<E> miaLista = new Lista1SuArray1<E>(dim);

		if (proxy)
			miaLista = new Lista1CopyOnWrite1<E>(miaLista);

		return new Lista1Sicura<E>(miaLista, nread, nwrite);
	}

}
