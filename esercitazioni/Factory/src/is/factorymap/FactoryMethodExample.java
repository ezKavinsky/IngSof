package Factory.src.is.factorymap;

import java.io.IOException;

public class FactoryMethodExample {

	public static void main (String[] arg) throws IOException {
		
		// Creates the tools for handling elements 
		ConnectorHandler cTool = new ConnectorHandler(); 
		PlaceHandler pTool = new PlaceHandler();
		
		// Vars
		Place startPoint, endPoint;
		Connector route;
		// Creates two places and one connector 
		System.out.println( "1st. place creation" ); 
		startPoint = (Place) pTool.createElement(); 
		System.out.println( "2nd. place creation" ); 
		endPoint = (Place) pTool.createElement(); 
		System.out.println( "Connector creation" ); 
		route = (Connector) cTool.createElement();
		
		// Links places with the connection 
		cTool.connect( route, startPoint , endPoint );
		
		// Paints the entire map 
		pTool.paintElement( startPoint ); 
		pTool.paintElement( endPoint ); 
		cTool.paintElement( route );
	}


}
