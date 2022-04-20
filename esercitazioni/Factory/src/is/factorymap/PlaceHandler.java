package Factory.src.is.factorymap;

public class PlaceHandler extends ElementHandler {
	/*
	 * ConcreteCreator
	 * Ridefinisce il factory method per restituire una istanza di ConcreteProduct. 
	 */
	
	
	public MapElement newElement() {
		return new Place();
	}
	
}