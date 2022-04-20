package Prototype.src.prototype;

public class SchedulerC {
	/*
	 * Client 
	 * Richiama il metodo di clonazione degli oggetti TimeImplementationC1 e
	 * TimeImplementationC2, per creare un nuovo oggetto.
	 */

	public static CloneableTime calculateEnd(CloneableTime start, int hours) {
		int hr = start.getHours() + hours;

		hr = hr % 24;

		CloneableTime endTime = start.clone();

		endTime.setTime(hr, start.getMinutes(), start.getSeconds());

		return endTime;
	}

}
