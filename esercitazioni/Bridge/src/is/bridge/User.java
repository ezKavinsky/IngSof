package Bridge.src.is.bridge;

import Bridge.src.is.bridge.utility.Document;
import Bridge.src.is.bridge.utility.PrinterStatus;
import Bridge.src.is.bridge.utility.Quality;

public class User {

	public static void main(String[] args) {
			
		C_Printer printer = new C_Printer();
		printer.setQualityPrintingLevel(Quality.low);
		PrinterStatus status = printer.print(new Document("test"),10,8);
		System.out.println(status);
		
		//-----------------------------------------------
		
		BW_Printer printerBW = new BW_Printer();
		printerBW.setQualityPrintingLevel(Quality.high);
		PrinterStatus statusBW= printerBW.print(new Document("prova"), 5, 3);
		System.out.println(statusBW);
		
		
		
	}
	
	
	
}
