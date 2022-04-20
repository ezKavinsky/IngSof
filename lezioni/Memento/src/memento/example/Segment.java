package Memento.src.memento.example;

import Memento.src.is.memento.Memento1;
import Memento.src.is.memento.Originator1;

import java.awt.geom.Point2D;

public class Segment implements Originator1 {
	private Point2D p1;
	private Point2D p2;

	public Segment(Point2D p1, Point2D p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public Memento1 getMemento() {
		return new LineMemento1();
	}

	@Override
	public void setMemento(Memento1 m) {
		if (!(m instanceof LineMemento1))
			throw new IllegalArgumentException();

		LineMemento1 lm = (LineMemento1) m;
		
		if (this != lm.getOriginator())
			throw new IllegalArgumentException();

		p1.setLocation(lm.p1);
		p2.setLocation(lm.p2);

	}

	private class LineMemento1 implements Memento1 {

		Point2D p1;
		Point2D p2;

		Segment getOriginator() {
			return Segment.this;
		}

		LineMemento1() {

			this.p1 = (Point2D) Segment.this.p1.clone();
			this.p2 = (Point2D) Segment.this.p2.clone();
		}

	}
}
