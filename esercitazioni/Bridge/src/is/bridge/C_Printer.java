package Bridge.src.is.bridge;

import Bridge.src.is.bridge.utility.Document;
import Bridge.src.is.bridge.utility.PrinterStatus;

public class C_Printer extends PrinterAbs{
	//RefinedAbstraction
	

	@Override
	public PrinterStatus print(Document doc, int copie, int angoloRotazione){
		PrinterStatus status = super.print(doc, copie, angoloRotazione);
		status.add("Tipo di stampa", "colore");
		return status;
	}
	
	public int getBlackLevel(){
		return ((ColorPrintImpl)lnkPrinterImpl).getBlackLevel();
	}

	public int getCyanLevel(){
		return ((ColorPrintImpl)lnkPrinterImpl).getCyanLevel();
	}

	public int getMagentaLevel(){
		return ((ColorPrintImpl)lnkPrinterImpl).getMagentaLevel();
	}

	public int getYellowLevel(){
		return ((ColorPrintImpl)lnkPrinterImpl).getYellowLevel();
	}
	
}
