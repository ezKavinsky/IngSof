package Prototype.src.prototype;

public class TimeImplementationC2 extends CloneableTime {

	/* ConcretePrototype
	 * Implementa una particolare versione di oggetti da utilizzare e clonare (estende CloneableTime). 
	 */
	
	private int secs;

	public void setTime(int hr, int min, int sec) { 
		secs = hr * 3600 + min * 60 + sec;
	}
	
	public int getHours() {
		return secs / 3600;
	}
	
	public int getMinutes() {
		return (secs - getHours()*3600) / 60;
	}
	
	public int getSeconds() {
		return secs % 60;
	}

}
