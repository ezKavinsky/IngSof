package Factory.src.is.factorycontratti;

public class FactoryArchiviDB implements FactoryArchivi {

    /*#is.contratti.ArchivioContrattiDB Dependency_Link*/

/*#is.contratti.ArchivioContrattiDB Dependency_Link1*/
/*#is.contratti.ArchivioClientiDB Dependency_Link2*/


public ArchivioClienti createArchivioClienti(){
        return null;
    }
    public ArchivioContratti<ContrattoTelefonico> createArchivioContrattiTelefonici(){
        return null;
    }
    public ArchivioContratti<ContrattoTelevisivo> createArchivioContrattiTelevisivi(){
        return null;
    }
	
}
