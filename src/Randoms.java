import java.security.SecureRandom;

/**
 * Artem Voytenko
 * 21.11.2018
 */

public class Randoms {
	private SecureRandom random = new SecureRandom();

	public String getInt(int border) {
		return "" + (random.nextInt(border) + 1);
	}

	public String getDouble() {
		return String.format("%.4f", random.nextDouble());
	}
}
