package samples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListIteration {

	public static void main(String args[]) {

		List<Integer> data = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			data.add(i + 1);
		}

		for (Integer integer : data) {
			System.out.print(integer);
		}

		Iterator<Integer> res = data.iterator();

		while (res.hasNext()) {
			if (res.next() == 5) {
				res.remove();
			}
		}

		System.out.println("*****************");

		for (Integer integer : data) {
			System.out.println(integer);
		}

	}
}