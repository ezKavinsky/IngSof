package Factory.src.is.factorycontratti;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;

public class ArchivioClientiTxt implements ArchivioClienti {

	private RandomAccessFile file;
	
	public ArchivioClientiTxt(String filename) throws FileNotFoundException {
		file = new RandomAccessFile(filename,"r");
	}

	public List<Cliente> getListaClienti() {
		try {
			file.seek(0);
			String s=null;
			List<Cliente> l = new LinkedList<Cliente>();
			while((s=file.readLine())!=null){
				Cliente c = new Cliente(s);
				l.add(c);
			}
			return l;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}		
	}

	public Cliente getClienteNome(String cognome, String nome) {
		try {
			file.seek(0);
			String s=null;
			while((s=file.readLine())!=null){
				Cliente c = new Cliente(s);
				if (c.getNome().equals(nome)&&c.getCognome().equals(cognome))
					return c;
			}
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Cliente getClienteCodice(String cod) {
		try {
			file.seek(0);
			String s=null;
			while((s=file.readLine())!=null){
				Cliente c = new Cliente(s);
				if (c.getCodice().equals(cod))
					return c;
			}
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
} // ArchivioClientiTestuale
