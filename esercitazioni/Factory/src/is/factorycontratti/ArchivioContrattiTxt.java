package Factory.src.is.factorycontratti;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.List;

public class ArchivioContrattiTxt <T extends Contratto> implements
ArchivioContratti<T > {

	private RandomAccessFile file;
	
	public ArchivioContrattiTxt(String filename) throws FileNotFoundException {
		file = new RandomAccessFile(filename,"r");
	}

	public List<T> getListaContratti() {
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