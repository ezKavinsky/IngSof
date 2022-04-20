package Bridge.src.is.nobridge;
public interface Printer {

	boolean areSheetsAvailable();

	void print(String doc) throws RuntimeException;
	
	void printTestPage() throws RuntimeException;
}
