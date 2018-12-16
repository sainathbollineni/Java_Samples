package samples;

//Best Time Complexity is O(n)
//Average Time Complexity is O(n2)
//Worst Time Complexity is O(n2)
//Using Bubble Sort Algorithm for every single pass Maximum Element of the Array will reach it's position
public class BubbleSort {

	public static void main(String args[]) {

		int data[] = { 23, 5, 7, 90, 456, 76, 34, 23, 67, 89, 4, 56 };

		for (int i : data) {
			System.out.print(i);
			System.out.print(" ");
		}

		System.out.println();

		data = bubbleSort(data);

		for (int i : data) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

	public static int[] bubbleSort(int data[]) {

		int size = data.length;

		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (data[j] > data[j + 1]) {
					int temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}
			}
		}

		return data;
	}
}