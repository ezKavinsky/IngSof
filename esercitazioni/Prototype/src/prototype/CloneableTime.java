package Prototype.src.prototype;

public abstract class CloneableTime implements Cloneable {
	
	/* Prototype
	 * Definisce l'interfaccia degli oggetti da utilizzare e implementa l�interfaccia 
	 * per clonarsi da s�, utilizzando il meccanismo di clonazione fornito da Java
	 */

	public abstract void setTime(int hr, int min, int sec);
	public abstract int getHours(); 
	public abstract int getMinutes(); 
	public abstract int getSeconds();

	@Override
	public CloneableTime clone() { 
		CloneableTime theClone=null;
		try {
			theClone = (CloneableTime) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theClone; 
		
	}

}
