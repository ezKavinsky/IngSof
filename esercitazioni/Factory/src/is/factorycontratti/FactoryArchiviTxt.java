package Factory.src.is.factorycontratti;

import java.io.FileNotFoundException;

public class FactoryArchiviTxt implements FactoryArchivi {

	/*#is.contratti.ArchivioContrattiTxt Dependency_Link*/

	/*#is.contratti.ArchivioContrattiTxt Dependency_Link1*/
	/*#is.contratti.ArchivioClientiTxt Dependency_Link2*/

	public ArchivioClienti createArchivioClienti() {
		try {
			return new ArchivioClientiTxt("test.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArchivioContratti<ContrattoTelefonico> createArchivioContrattiTelefonici() {
		try {
			return new ArchivioContrattiTxt<ContrattoTelefonico>(
					"telefonici.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArchivioContratti<ContrattoTelevisivo> createArchivioContrattiTelevisivi() {
		try {
			return new ArchivioContrattiTxt<ContrattoTelevisivo>(
					"televisivi.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
