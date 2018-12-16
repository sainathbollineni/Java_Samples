package samples;

public class ReverseString {

	public static void main(String args[]) {
		String res = reverseString("SaiNath");
		System.out.println(res);
	}

	public static String reverseString(String input) {
		if (null != input && !input.isEmpty()) {
			return reverseString(input.substring(1)) + input.charAt(0);
		} else
			return "";
	}
}