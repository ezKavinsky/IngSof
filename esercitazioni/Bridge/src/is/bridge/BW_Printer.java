package Bridge.src.is.bridge;

import Bridge.src.is.bridge.utility.Document;
import Bridge.src.is.bridge.utility.PrinterStatus;

public class BW_Printer extends PrinterAbs{
	//RefinedAbstraction
	

	public int getBlackLevel(){
		return ((BWPrintImpl)lnkPrinterImpl).getBlackLevel();
	}
	
	@Override
	public PrinterStatus print(Document doc, int copie, int angoloRotazione){
		PrinterStatus status = super.print(doc, copie, angoloRotazione);
		status.add("Tipo di stampa", "Bianco e nero");
		return status;
	}
	
}
