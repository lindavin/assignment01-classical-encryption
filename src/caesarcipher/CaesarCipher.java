package caesarcipher;

import java.io.PrintWriter;

public class CaesarCipher {

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
	public static char caesarShift(int n, char ch, String option) throws IllegalArgumentException{

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
	
	public static void caesarShiftLoop() {
		
	} // caesarShiftLoop(String, PenWriter)

	public static void main(String args[]) throws Exception {
		// task 2: think about cipher
		// task 3: implement cipher

		PrintWriter pen = new PrintWriter(System.out);

		if (args.length != 2) {
			System.err.println("Incorrect number of parameters");
			System.exit(1);
		}
		switch (args[0]) {
		case "encode":
			pen.println("encode option " + caesarShift(1,'a', "encode"));
			pen.flush();
			break;
		case "decode":
			pen.println("decode option");
			pen.flush();
			break;
		default:
			System.err.println("Valid options are \"encode\" or \"decode\"");
			System.exit(1);
		}


	} // main(String[])
} // class CaesarCipher
