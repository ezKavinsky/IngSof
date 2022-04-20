package Strategy.src.is.strategy;

public class StrategyExample {

	public static void main(String[] arg) {
		SortingContext s = new SortingContext();

		int[] v = { 3, 2, 1, 4, 5 };
		int[] v2 = { 8, 7, 6, 5, 9 };

		//si istanzia una particolare strategia
		s.setSortingMethod(new InsertionSort());
		System.out.println("Sorted by InsertionSort");
		s.sortNumbers(v);

		//si istanzia una particolare strategia
		s.setSortingMethod(new SelectionSort());
		System.out.println("\nSorted by SelectionSort");
		s.sortNumbers(v2);

	}
}
