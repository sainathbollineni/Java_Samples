package samples;

class MergeSort {

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();

		int leftIndex = 0;
		int rightIndex = arr.length - 1;

		ob.sort(arr, leftIndex, rightIndex);

		System.out.println("\nSorted array");
		printArray(arr);
	}

	void sort(int arr[], int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex) {
			int middleIndex = (leftIndex + rightIndex) / 2;

			sort(arr, leftIndex, middleIndex);

			sort(arr, middleIndex + 1, rightIndex);

			// Merge the sorted halves
			merge(arr, leftIndex, middleIndex, rightIndex);
		}
	}

	void merge(int arr[], int leftIndex, int middleIndex, int rightIndex) {
		// Find sizes of two sub arrays to be merged
		int n1 = middleIndex - leftIndex + 1;
		int n2 = rightIndex - middleIndex;

		/* Create temp arrays */
		int leftArray[] = new int[n1];
		int rightArray[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; i++)
			leftArray[i] = arr[leftIndex + i];
		for (int j = 0; j < n2; j++)
			rightArray[j] = arr[middleIndex + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = leftIndex;
		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
