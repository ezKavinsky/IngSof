package Factory.src.is.factorycontratti;

import java.util.List;

public class ArchivioGenerale {
	
	
	
	/**
	 * @directed true
	 */
	
	private Factory.src.is.factorycontratti.FactoryArchivi lnkFactoryArchivi;

	/**
	 * @directed true
	 * @link aggregationByValue
	 */
	
	ArchivioContratti<ContrattoTelefonico> contrattiTelefonici;
	
	/**
	 * @directed true
	 * @link aggregationByValue
	 */
	
	ArchivioContratti<ContrattoTelevisivo> contrattiTelevisivi;
	
	/**
	 * @directed true
	 * @link aggregationByValue
	 */
	
	ArchivioClienti clienti;
	
	/*
	 * query 
	 */

	public ArchivioGenerale(FactoryArchivi factory) {
		clienti = factory.createArchivioClienti();
		contrattiTelefonici = factory.createArchivioContrattiTelefonici();
		contrattiTelevisivi = factory.createArchivioContrattiTelevisivi();
	}

	public Cliente cercaCliente(String cod) {
		return clienti.getClienteCodice(cod);
	}

	public ContrattoTelevisivo cercaContrattoTelevisivo(String cod) {
		return contrattiTelevisivi.getContrattoCodice(cod);
	}

	public ContrattoTelefonico cercaContrattoTelefonico(String num) {
		return contrattiTelefonici.getContrattoCodice(num);
	}

	public List<ContrattoTelefonico> cercaContrattiTelCli(String cognome, String nome) {
		Cliente cli = clienti.getClienteNome(cognome, nome);
		return contrattiTelefonici.getContrattiCliente(cli.getCodice());

	}
}
