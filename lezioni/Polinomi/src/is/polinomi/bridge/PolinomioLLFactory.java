package Polinomi.src.is.polinomi.bridge;

public class PolinomioLLFactory implements PolinomioImplFactory {

	@Override
	public PolinomioImpl createPolinomioImpl() {

		return new PolinomioLL();
	}

}
