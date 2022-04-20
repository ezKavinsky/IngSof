package Factory.src.is.factorycontratti;

import java.util.StringTokenizer;

public class ContrattoTelefonico implements Contratto{

	private String codiceCliente;
	private String numeroTelefonico;
	private String tipoContratto;
	private double tariffa;

	public ContrattoTelefonico(
		String codCli,
		String num,
		String tipo,
		double t) {
		codiceCliente = codCli;
		numeroTelefonico = num;
		tipoContratto = tipo;
		tariffa = t;
	}

	/**
	 * Get the value of tariffa.
	 * @return value of tariffa.
	 */
	public double getTariffa() {
		return tariffa;
	}

	/**
	 * Set the value of tariffa.
	 * @param v  Value to assign to tariffa.
	 */
	void setTariffa(double v) {
		this.tariffa = v;
	}

	/**
	 * Get the value of tipoContratto.
	 * @return value of tipoContratto.
	 */
	public String getTipoContratto() {
		return tipoContratto;
	}

	/**
	 * Get the value of codiceCliente.
	 * @return value of codiceCliente.
	 */
	public String getCodiceCliente() {
		return codiceCliente;
	}

	/**
	 * Get the value of numeroTelefonico.
	 * @return value of numeroTelefonico.
	 */
	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public ContrattoTelefonico(String s) {
		StringTokenizer st = new StringTokenizer(s,"-");
		this.codiceCliente = st.nextToken();
		this.numeroTelefonico = st.nextToken();
		this.tipoContratto = st.nextToken();
		this.tariffa = Double.parseDouble(st.nextToken());
	}
	
	public String toString(){
		return codiceCliente+"-"+numeroTelefonico+"-"+tipoContratto+"-"+tariffa;
	}
	
	
	

}
