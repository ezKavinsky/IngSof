package Memento.src.is.memento;

public class ProcessingUnit implements Originator1 {

	
	/**
	 * @directed true
	 * @link composition
	 */
	private Accumulator acc = new AccumulatorImpl(0);
	/*#is.memento.Operation Dependency20*/

	public Memento1 createMemento() {
		return new AccumulatorImpl(acc);
	}

	public void setMemento(Memento1 m) {
		acc = (Accumulator)m;		
	}
	
	public void process(Operation op, double val){
		switch (op) {
		case add:
			acc.setValue(acc.getValue()+val);
			break;		
		case sub:
			acc.setValue(acc.getValue()-val);
			break;
		case mul:
			acc.setValue(acc.getValue()*val);
			break;
		case div:
			acc.setValue(acc.getValue()/val);
			break;
		}
	}
	
	public double getCurrentComputationValue(){
		return acc.getValue();
	}
}
