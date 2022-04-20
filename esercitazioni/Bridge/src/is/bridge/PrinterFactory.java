package Bridge.src.is.bridge;
public class PrinterFactory {
	
	public static PrinterAbs createPrinter(){
		return new BW_Printer();
	}

	public static C_Printer createColorPrinter(){
		return new C_Printer();
	}
	
	public static BW_Printer getBWPrinter(){
		return new BW_Printer();
	}

}
