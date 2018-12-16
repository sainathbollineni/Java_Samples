package samples;

//Best Time Complexity is O(n2)
//Average Time Complexity is O(n2)
//Worst Time Complexity is O(n2)
//Using Selection Sort, for every pass we will select the next minimum element of the array and place in it's position
public class SelectionSort {

	public static void main(String[] args) throws InterruptedException {

		int data[] = { 23, 5, 7, 90, 456, 76, 34, 23, 67, 89, 4, 56 };

		for (int i : data) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();

		data = selectionSort1(data);

		for (int i : data) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

	public static int[] selectionSort(int data[]) throws InterruptedException {

		for (int i = 0; i < data.length; i++) {
			int minIndex = findMinIndex(data[i], data, i);

			if (-1 == minIndex) {
				continue;
			} else {
				int temp = data[i];
				data[i] = data[minIndex];
				data[minIndex] = temp;
			}
		}

		return data;
	}

	public static int findMinIndex(int minValue, int[] data, int index) throws InterruptedException {

		int minIndex = -1;

		for (int i = (index + 1); i < data.length; i++) {
			if (data[i] <= minValue) {
				minIndex = i;
				minValue = data[i];
			}
		}
		return minIndex;
	}

	public static int[] selectionSort1(int data[]) throws InterruptedException {

		for (int i = 0; i < data.length; i++) {
			int minIndex = -1;
			int minValue = data[i];

			for (int j = (i + 1); j < data.length; j++) {
				if (data[j] <= minValue) {
					minIndex = j;
					minValue = data[j];
				}
			}

			if (-1 == minIndex) {
				continue;
			} else {
				int temp = data[i];
				data[i] = minValue;
				data[minIndex] = temp;
			}
		}

		return data;
	}

}
