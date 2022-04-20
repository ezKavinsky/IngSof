package Factory.src.is.factorycontratti;

import java.util.List;

public class ProxyArchivioContratti<T extends Contratto> implements ArchivioContratti<T> {
	
	
	/**
	 * @directed true
	 * @link aggregationByValue
	 * @supplierCardinality 2
	 */
	
	private ArchivioContratti<T> archivio;
	
	public ProxyArchivioContratti(ArchivioContratti<T> archivio){
		this.archivio=archivio;
	}
	
	public List<T> getListaContratti() {
		// TODO Auto-generated method stub
		return null;
	}

	public T getContrattoCodice(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> getContrattiCliente(String codCli) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> getContrattiTipo(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> getContrattiClienteTipo(String codCli, String tipo) {
		// TODO Auto-generated method stub
		return null;
	}	
}
