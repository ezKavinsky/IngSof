package Factory.src.is.factorycontratti;

public class ContrattoTelevisivo implements Contratto{
	private String codiceCliente;
	private String tipoContratto;
	private double tariffa;
	private String codice;
	public ContrattoTelevisivo(
		String cod,
		String codCli,
		String tipo,
		double tar) {

		codice = cod;
		codiceCliente = codCli;
		tipoContratto = tipo;
		tariffa = tar;
	}
	public String getCodice() {
		return codice;
	}

	/**
		* Gets the value of codiceCliente
		*
		* @return the value of codiceCliente
		*/
	public String getCodiceCliente() {
		return this.codiceCliente;
	}

	/**
		* Gets the value of tipoContratto
		*
		* @return the value of tipoContratto
		*/
	public String getTipoContratto() {
		return this.tipoContratto;
	}

	/**
		* Gets the value of tariffa
		*
		* @return the value of tariffa
		*/
	public double getTariffa() {
		return this.tariffa;
	}

}
