package Prototype.src.prototype;

public class TimeImplementationC1 extends CloneableTime {
	
	/* ConcretePrototype
	 * Implementa una particolare versione di oggetti da utilizzare e clonare (estende CloneableTime). 
	 */

	private int hr, min, sec;

	@Override
	public void setTime(int hr, int min, int sec) {
		this.hr = hr;
		this.min = min;
		this.sec = sec;

	}

	@Override
	public int getHours() {
		return hr;
	}

	@Override
	public int getMinutes() {
		return min;
	}

	@Override
	public int getSeconds() {
		return sec;
	}


}
