package Memento.src.is.memento;

public abstract class CareTaker {

	/*#is.memento.Originator Dependency20*/
	/**
	 * @directed true
	 * @link composition
	 */
	private static Memento1[] mem = new Memento1[10];

	
	public static void main(String[] args) {
		ProcessingUnit pu = new ProcessingUnit();
		
		pu.process(Operation.add, 10);
		
		System.out.println("Stato iniziale della computazione: "+pu.getCurrentComputationValue());
		
		mem[0] = pu.createMemento();
				
		//System.out.println("mem[0] = "+((AccumulatorImpl)mem[0]).getValue());
		
		final int numOp = 100000000;
		for(int i=0;i<numOp;i++)
			pu.process(Operation.add, 0.1);
		System.out.println("Valore attuale della computazione dopo somme: "+pu.getCurrentComputationValue());
		
		for(int i=0;i<numOp;i++)
			pu.process(Operation.add.undo(), 0.1);
		System.out.println("Valore della computazione dopo undo con sottrazioni: "+pu.getCurrentComputationValue());

		//System.out.println("mem[0] = "+((AccumulatorImpl)mem[0]).getValue());
		
		pu.setMemento(mem[0]);
		System.out.println("Valore della computazione dopo undo con memento: "+pu.getCurrentComputationValue());		
		
	}
	
}
