package Memento.src.is.memento;
public class AccumulatorImpl implements Accumulator{
	
	private static final long serialVersionUID = 4644289305884060794L;

	
	private double value;
	
	public AccumulatorImpl(Accumulator m){
		this.value = m.getValue();
	}

	public AccumulatorImpl(double value){
		this.value = value;
	}
	
	public double getValue(){
		return value;
	}
	
	public void setValue(double value){
		this.value=value;
	}

}
