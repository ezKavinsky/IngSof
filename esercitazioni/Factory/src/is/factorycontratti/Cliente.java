package Factory.src.is.factorycontratti;

import java.util.StringTokenizer;

public class Cliente {

	private String codice;

	private String nome;

	private String cognome;

	private String indirizzo;

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCodice() {
		return codice;
	}

	public void setIndirizzo(String nuovoInd) {
		indirizzo = nuovoInd;
	}
	
	public String toString(){
		return codice+"-"+nome+"-"+cognome+"-"+indirizzo;
	}

	public Cliente(String codice, String nome, String cognome, String indirizzo) {
		this.codice = codice;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
	}
	
	public Cliente(String s){
		StringTokenizer st = new StringTokenizer(s,"-");
		this.codice = st.nextToken();
		this.nome = st.nextToken();
		this.cognome = st.nextToken();
		this.indirizzo = st.nextToken();
	}
	
	
}
