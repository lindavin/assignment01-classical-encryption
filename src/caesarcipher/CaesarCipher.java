package caesarcipher;

import java.io.PrintWriter;

public class CaesarCipher {

	/**
	 * Wrapped modular 
	 * @param mod
	 * @param a
	 * @return a (mod) mod
	 */
	public static int wrappedMod(int mod, int a) {
		return ((a % mod) < 0) ? ((a % mod) + mod) : (a % mod);
	} // wrappedMod(int, int)

	/**
	 * Shifts a given char alpha n number depending on String option
	 * 
	 * @param n
	 * @param alpha
	 * @return shifted Character
	 */
	public static char caesarShift(int n, char ch, String option) throws IllegalArgumentException {

		int base = (int) 'a';
		int reBase = ((int) ch) - base;

		switch (option) {
		case "encode":
			return (char) (wrappedMod(26, reBase + n) + base);
		case "decode":
			return (char) (wrappedMod(26, reBase - n) + base);
		default:
			System.err.println("Valid options are \"encode\" or \"decode\"");
			throw new IllegalArgumentException("Valid options are \"encode\" or \"decode\"");
		}
	} // casearShift(int, char, String)

	public static void caesarShiftLoop(String str, String option, PrintWriter pen) {
		for (int n = 0; n < 26; n++) {
			pen.print("n = " + n + ": ");
			for (int i = 0; i < str.length(); i++) {
				pen.print(caesarShift(n, str.charAt(i), option));
			}
			pen.println();
		}
	} // caesarShiftLoop(String, String, PrintWriter)

	public static void main(String args[]) throws Exception {

		PrintWriter pen = new PrintWriter(System.out);

		if (args.length != 2) {
			System.err.println("Incorrect number of parameters");
			System.exit(1);
		}
		switch (args[0]) {
		case "encode":
		case "decode":
			caesarShiftLoop(args[1], args[0], pen);
			break;
		default:
			System.err.println("Valid options are \"encode\" or \"decode\"");
			System.exit(1);
		}
		pen.close();
	} // main(String[])
} // class CaesarCipher

//Time taken: 80 minutes
