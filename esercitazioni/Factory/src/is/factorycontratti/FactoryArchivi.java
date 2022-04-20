package Factory.src.is.factorycontratti;

public interface FactoryArchivi {
	ArchivioClienti createArchivioClienti();
	ArchivioContratti<ContrattoTelefonico> createArchivioContrattiTelefonici();
	ArchivioContratti<ContrattoTelevisivo> createArchivioContrattiTelevisivi();
}
