package Memento.src.is.memento;
public enum Operation { 
	
	add, sub, mul, div; 
	
	public Operation undo(){
		switch(this){
		case add: return sub;
		case sub: return add;
		case div: return mul;
		case mul: return div;
		}
		throw new IllegalArgumentException();
	}

}
