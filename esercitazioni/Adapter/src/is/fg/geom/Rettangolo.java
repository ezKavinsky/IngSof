
package is.fg.geom;


public class Rettangolo implements Figura2D {

	private double base;
	private double altezza;
	
	public Rettangolo(double b,double a){
		if(a<=0||b<=0)throw new IllegalArgumentException();
		base=b;
		altezza=a;
	}
	public double area() {
		
		return base*altezza;
	}

	
	public double perimetro() {
		
		return 2*base+2*altezza;
	}
	public double getBase(){
		return base;
	}
	public double getAltezza(){
		return altezza;
	}
}
