
package is.fg.geom;

import is.fg.figure.FigRombo;

/**
 * @author ludov
 * PATTERN DECORATOR CLASS
 *
 */
public class Rombo extends FigRombo implements Figura2D  {
	
	public Rombo(double d1,double d2){
		super(d1,d2);
	}
	
	public double area() {

		return getD1()*getD2()/2.0;
	}

	public double perimetro() {
		double sd1 = getD1()/2.0;
		double sd2 = getD2()/2.0;
		double lato = Math.sqrt(sd1*sd1+sd2*sd2);
		return 4*lato; 
	}

}
