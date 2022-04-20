package Bridge.src.is.bridge;

import Bridge.src.is.bridge.utility.Document;
import Bridge.src.is.bridge.utility.PrinterStatus;
import Bridge.src.is.bridge.utility.Quality;

public abstract class PrinterAbs {
	/*
	 * Abstraction
	 * - Specifica l’astrazione
	 * - Gestisce un riferimento ad un oggetto Implementor.
	 */

	/**
	 * @directed true
	 * @link composition
	 */
	protected final Bridge.src.is.bridge.PrinterImpl lnkPrinterImpl;

	private int printedPage;
	private Quality currentQuality;
	
	public boolean areSheetsAvailable(){
		return lnkPrinterImpl.areSheetsAvailable();
	}

	public void setQualityPrintingLevel(Quality q){
		currentQuality = q;
		if (q.equals(Quality.low)){
			int l = lnkPrinterImpl.getLowestResolution();
			lnkPrinterImpl.setResolution(l);
		}else if (q.equals(Quality.medium)){
			int l = lnkPrinterImpl.getLowestResolution();
			int h = lnkPrinterImpl.getHighestResolution();
			lnkPrinterImpl.setResolution((l+h)/2);
		}else{
			int h = lnkPrinterImpl.getHighestResolution();
			lnkPrinterImpl.setResolution(h);
		}
	}

	public Quality getQualityPrintingLevel(){
		return currentQuality;
	}

	public int getPrintedPageNumber(){
		return printedPage;
	}
	
	//metodo a puro scopo di esempio
	private static byte[][] fromDocToRaw(Document doc){
		//algortitmo di trasformazione
		return null;
	}
	
	//metodo a puro scopo di esempio
	private static byte[][] rotate(byte[][] data, int angoloRotazione){
		//algortitmo di rotazione
		return null;
	}
	
	public PrinterStatus print(Document doc, int copie, int angoloRotazione){
		byte[][] raw = fromDocToRaw(doc);
		byte[][] rr = rotate(raw,angoloRotazione);
		for(int i=0; i<copie; i++){
			lnkPrinterImpl.print(rr);
			printedPage++;
		}
		PrinterStatus status = new PrinterStatus();
		status.add("Copie Stampe", String.valueOf(copie));
		status.add("Copie Totali", String.valueOf(printedPage));
		status.add("Risoluzione ",currentQuality.toString());
		return status;
	}
	
	//in questo caso ci si lega alla classe concreta
	public PrinterAbs(){
		lnkPrinterImpl = new M1_LCP_HighQuality();
	}
	
	//non ci si lega alla classe concreta
	public PrinterAbs(PrinterImpl pri){
		lnkPrinterImpl = pri;
	}
	
}
