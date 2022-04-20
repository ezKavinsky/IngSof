package Strategy.src.is.strategy;

import java.util.Arrays;

public class SelectionSort implements SortingStrategy {
	
	public void sort(int[] v) {
		int first;
		int temp;
		for (int index = v.length - 1; index > 0; index--) {
			first = 0;
			for (int j = 1; j <= index; j++) {
				if (v[j] > v[first])
					first = j;
			}
			temp = v[first];
			v[first] = v[index];
			v[index] = temp;
		}
		System.out.println(Arrays.toString(v));
	}
}
