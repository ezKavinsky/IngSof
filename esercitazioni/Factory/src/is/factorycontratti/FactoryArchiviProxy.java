package Factory.src.is.factorycontratti;

public class FactoryArchiviProxy implements FactoryArchivi{
	
	/*#is.contratti.ProxyArchivioClienti Dependency_Link*/
/*#is.contratti.ProxyArchivioContratti Dependency_Link1*/

/**
	 * @directed true
	 * @link aggregationByValue
	 */
	
	private FactoryArchivi factory;
	
	public FactoryArchiviProxy(FactoryArchivi f) {
		factory = f;
	}

	public ProxyArchivioClienti createArchivioClienti() {
		return new ProxyArchivioClienti(factory.createArchivioClienti());
	}

	public ArchivioContratti<ContrattoTelefonico> createArchivioContrattiTelefonici() {
		return new ProxyArchivioContratti<ContrattoTelefonico>(factory.createArchivioContrattiTelefonici());
	}

	public ArchivioContratti<ContrattoTelevisivo> createArchivioContrattiTelevisivi() {
		return new ProxyArchivioContratti<ContrattoTelevisivo>(factory.createArchivioContrattiTelevisivi());
	}

}
