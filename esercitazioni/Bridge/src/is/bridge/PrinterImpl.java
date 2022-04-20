package Bridge.src.is.bridge;
public interface PrinterImpl {
	/*
	 * Specifica l’interfaccia definita per le classi di implementazione
	 */
	
	boolean areSheetsAvailable();

	void print(byte[][] data) throws RuntimeException;
	
	void printTestPage() throws RuntimeException;
	
	int getCurrentResolution();

	int getLowestResolution();

	int getHighestResolution();

	void setResolution(int dotPerInch);	
	
}
