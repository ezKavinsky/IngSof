package Factory.src.is.factorycontratti;

import java.util.List;

public interface ArchivioContratti<T extends Contratto> {
	/**
	 * @directed true
	 * @link composition
	 * @supplierCardinality 0..*
	 */
	public Factory.src.is.factorycontratti.Contratto lnkContratto = null;
	List<T> getListaContratti();
	T getContrattoCodice(String cod);
	List<T> getContrattiCliente(String codCli);
	List<T> getContrattiTipo(String tipo);
	List<T> getContrattiClienteTipo(String codCli, String tipo);

}
