package Factory.src.is;

import Factory.src.is.factorycontratti.*;

import java.util.List;

public class TestContratti {
	
	public static void main(String[] args){
		
		FactoryArchivi factory = new FactoryArchiviTxt();
		
		ArchivioClienti ac = factory.createArchivioClienti();		
		List<Cliente> l=ac.getListaClienti();		
		System.out.println(l);
		
		ArchivioGenerale ag = new ArchivioGenerale(factory);
		Cliente c = ag.cercaCliente("cod2");
		System.out.println(c);
		
	}
		
}
