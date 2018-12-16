package samples;

import java.text.SimpleDateFormat;

public class NullDateFormat {
	public static void main(String args[]) {
		final String DATETIME_PATTERN = "dd/MM/YYYY HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_PATTERN);
		String Prevtimestamp = sdf.format(null);
	}
}