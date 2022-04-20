package Factory.src.is.factorymap;

public class ConnectorHandler extends ElementHandler {
	/*
	 * ConcreteCreator 
	 * Ridefinisce il factory method per restituire una istanza di
	 * ConcreteProduct. Ovvero estende l�ElementHandler e implementa il metodo
	 * newElement, per creare oggetti della classe Connector.
	 */

	public MapElement newElement() {
		return new Connector();
	}

	public void connect(Connector conn, Place origin, Place destination) {
		/*
		 * Funzionalit� aggiuntiva, che serve a connettere due luoghi.
		 */
		conn.setPlacesConnected(origin, destination);
	}

}
