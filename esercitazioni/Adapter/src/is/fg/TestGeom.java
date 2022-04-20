package is.fg;

import is.fg.geom.*;

public class TestGeom {

	public static void main(String[] args) {
		ListaFigure lf = new ListaFigure();
		lf.add(new Rombo(3,4));
		lf.add(new Rettangolo(2,3));
		lf.add(new Cerchio(3.1));
		lf.add(new Triangolo(3,4,5));
		lf.add(new Quadrato(4));
		
		System.out.println("area media "+lf.areaMedia());
		System.out.println("perimetro medio "+lf.perimetroMedio());
	}
}
