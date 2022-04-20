package Factory.src.is.factorymap;

public class Place implements MapElement {
	//ConcreteProduct
	
	private String placeLabel;
	
	@Override
	public void setLabel( String label ) {
		placeLabel = label;
	}

	@Override
	public String getPaintingData() { 
		return "city: "+ placeLabel;
	}

}
