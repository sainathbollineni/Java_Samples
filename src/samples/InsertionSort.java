package samples;

public class InsertionSort {

	public static void main(String[] args) {
		int data[] = { 23, 5, 7, 90, 456, 76, 34, 23, 67, 89, 4, 56 };

		for (int i : data) {
			System.out.print(i);
			System.out.print(" ");
		}

		System.out.println();

		data = insertionSort(data);

		for (int i : data) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

	public static int[] insertionSort(int data[]) {

		for (int i = 1; i < data.length; i++) {
			int value = data[i];
			int index = i;

			for (int j = 0; j < i; j++) {
				if (data[j] > value) {
					data[i] = data[j];
					index = j;
				}
			}

			data[index] = value;
		}

		return data;
	}
}
