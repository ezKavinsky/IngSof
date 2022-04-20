package Factory.src.is.factorycontratti;

import java.util.*;

public class ProxyArchivioClienti implements ArchivioClienti {
	
	/**
	 * @associatesType composition
	 * @directed true
	 * @link composition
	 */
	
	private ArchivioClienti archivio;
	
	//Mappa che contiene le associazioni Codice-Cliente
	private final Map<String,Cliente> map = new HashMap<String,Cliente>();
	private boolean caricatiTutti = false;

	public ProxyArchivioClienti(ArchivioClienti arch) {
		archivio = arch;
	}
	
	public List<Cliente> getListaClienti() {
		if (caricatiTutti)
			return new LinkedList<Cliente>(map.values());

		caricatiTutti = true;
		List<Cliente> l = archivio.getListaClienti();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Cliente c = (Cliente) it.next();
			map.put(c.getCodice(), c);
		}
		return l;
	}
	public Cliente getClienteNome(String cognome, String nome) {
		Cliente c = archivio.getClienteNome(cognome, nome);

		if (c != null && !map.containsKey(c.getCodice())) {
			map.put(c.getCodice(), c);
		}
		return c;

	}
	public Cliente getClienteCodice(String cod) {

		if (map.containsKey(cod))
			return  map.get(cod);
		else {

			Cliente c = archivio.getClienteCodice(cod);
			if (c != null)
				map.put(cod, c);
			return c;
		}
	}

}
