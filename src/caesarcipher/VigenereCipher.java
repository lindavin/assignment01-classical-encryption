package caesarcipher;

import java.io.PrintWriter;

public class VigenereCipher {

	/**
	 * A static method of the Vigenere Cipher
	 * 
	 * @param str
	 * @param key
	 * @param option
	 * @param pen
	 */
	public static void vigenereCipher(String str, String key, String option, PrintWriter pen) {
		for (int i = 0; i < str.length(); i++) {
			int base = (int) 'a';
			char strChar = str.charAt(i);
			char keyChar = key.charAt(CaesarCipher.wrappedMod(key.length(),i));
			int n = ((int) keyChar) - base;
			pen.print(CaesarCipher.caesarShift(n, strChar, option));
		}
		pen.println();
	}
	
	/**
	 * A simple implementation of the Vigenere Cipher
	 * 
	 * @author Davin Lin
	 * @param args
	 * @preconditions The user only gives lowercase inputs
	 * 
	 */
	public static void main(String args[]) {
		PrintWriter pen = new PrintWriter(System.out);

		if (args.length != 3) {
			System.err.println("Incorrect number of parameters");
			System.exit(1);
		}
		switch (args[0]) {
		case "encode":
		case "decode":
			vigenereCipher(args[1], args[2], args[0], pen);
			break;
		default:
			System.err.println("Valid options are \"encode\" or \"decode\"");
			System.exit(1);
		}
		pen.close();
	} // main(String[])
}

//Took 31 minutes
