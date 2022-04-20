
package is.fg.geom;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ListaFigure {
	
	
	/**
	 * @directed true
	 * @link association
	 */
	private List<Figura2D> l = new LinkedList<Figura2D>();

	public void add(Figura2D f) {
		l.add(f);
	}

	public void remove(Figura2D f) {
		l.remove(f);
	}

	public double areaMedia() {
		double a = 0.0;
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Figura2D f = (Figura2D) it.next();
			a += f.area();
		}
		return a / l.size();

	}

	public double perimetroMedio() {
		double p = 0.0;
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Figura2D f = (Figura2D) it.next();
			p += f.perimetro();
		}
		return p / l.size();

	}
}