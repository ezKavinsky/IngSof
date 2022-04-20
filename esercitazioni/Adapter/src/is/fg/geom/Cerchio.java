
package is.fg.geom;


public class Cerchio implements Figura2D {
	private double raggio;
	public Cerchio(double r){
		if(r<=0)throw new IllegalArgumentException();
		raggio=r;
	}
	public double area() {
		
		return raggio*raggio*Math.PI;
	}

	
	public double perimetro() {
	
		return 2*Math.PI*raggio;
	}
	public double getRaggio(){
		return raggio;
	}

}
