package Bridge.src.is.bridge.utility;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PrinterStatus {
	
	private final Map<String,String> mappa = new HashMap<String, String>();
	
	public void add(String chiave, String valore){
		mappa.put(chiave, valore);
	}
	
	public Iterator<String> getChiavi(){
		return mappa.keySet().iterator();
	}
	
	public String getValore(String key){
		return mappa.get(key);
	}

	@Override
	public String toString() {
		return mappa.toString();
	}
}
