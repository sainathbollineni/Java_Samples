package samples;

public class MergeSortExample {

	public static void main(String args[]) {

		int data[] = { 23, 5, 7, 90, 456, 76, 34, 23, 67, 89, 4, 56 };

		for (int i : data) {
			System.out.print(i);
			System.out.print(" ");
		}

		System.out.println();

		MergeSort ob = new MergeSort();
		ob.sort(data, 0, data.length - 1);

		System.out.println("\nSorted array");
		for (int i : data) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

	public void sort(int arr[], int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex) {
			int middleIndex = (leftIndex + rightIndex) / 2;

			sort(arr, leftIndex, middleIndex);

			sort(arr, (middleIndex + 1), rightIndex);

			mergeSort(arr, leftIndex, middleIndex, rightIndex);
		}
	}

	public void mergeSort(int arr[], int leftIndex, int middleIndex, int rightIndex) {

		int firstArrayLength = middleIndex - leftIndex + 1;
		int secondArrayLength = rightIndex - middleIndex;

		int[] firstArray = new int[firstArrayLength];
		int[] secondArray = new int[secondArrayLength];

		for (int i = 0; i < firstArrayLength; i++) {
			firstArray[i] = arr[i + leftIndex];
		}

		for (int j = 0; j < secondArrayLength; j++) {
			secondArray[j] = arr[j + middleIndex + 1];
		}

		int i = 0, j = 0, k = leftIndex;

		while (i < firstArrayLength && j < secondArrayLength) {
			if (firstArray[i] <= secondArray[j]) {
				arr[k] = firstArray[i];
				i++;
			} else {
				arr[k] = secondArray[j];
				j++;
			}
			k++;
		}

		while (i < firstArrayLength) {
			arr[k] = firstArray[i];
			i++;
			k++;
		}

		while (j < secondArrayLength) {
			arr[k] = secondArray[j];
			j++;
			k++;
		}

	}

}