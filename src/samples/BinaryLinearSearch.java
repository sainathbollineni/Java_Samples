package samples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryLinearSearch {

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int a[] = { 2, 5, 8, 19, 34, 56, 78, 98, 134, 456, 368 };
			int valueToFind = Integer.parseInt(br.readLine());

			int result = binaryLinearSearch(a, valueToFind);

			if (result == -1) {
				System.out.println("Value not found in the given list of elements");
			} else {
				System.out.println("Value found in the given list of elements at index :: " + result);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public static int binaryLinearSearch(int inputData[], int valueToFind) {
		int minIndex = 0;
		int maxIndex = inputData.length - 1;

		while (minIndex <= maxIndex) {

			int middleIndex = (minIndex + maxIndex) / 2;

			if (inputData[middleIndex] == valueToFind) {
				return middleIndex;
			} else if (valueToFind > inputData[middleIndex]) {
				minIndex = middleIndex + 1;
			} else {
				maxIndex = middleIndex - 1;
			}
		}
		return -1;
	}
}