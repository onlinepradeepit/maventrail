package in.com.pradeepit.service.util;

import org.apache.commons.lang.Validate;

// TODO: Auto-generated Javadoc
/**
 * The Class NumberUtil.
 */
public class NumberUtil {

	/**
	 * Mask number.
	 *
	 * @param number            The number in plain format
	 * @param mask            The mask pattern. Use # to include the digit from the
	 *            position. Use x to mask the digit at that position. Any other
	 *            char will be inserted.
	 * @return The masked card number
	 */
	public static String maskNumber(String number, String mask) {

		validateMaskNumber(number, mask);
		int index = 0;
		StringBuilder masked = new StringBuilder();
		for (int i = 0; i < mask.length(); i++) {
			char c = mask.charAt(i);
			if (c == '#') {
				masked.append(number.charAt(index));
				index++;
			} else if (c == 'x' || c == 'X') {
				masked.append(c);
				index++;
			} else {
				masked.append(c);
			}
		}
		return masked.toString();
	}

	/**
	 * Validate mask number.
	 *
	 * @param number the number
	 * @param mask the mask
	 */
	private static void validateMaskNumber(String number, String mask) {

		Validate.notNull(number, "Number must not be empty");
		Validate.notNull(number, "Mask Format must not be empty");
		if ((mask.indexOf("X") == -1)) {
			if ((mask.indexOf("x") == -1)) {
				if ((mask.indexOf("#") == -1)) {
					throw new IllegalArgumentException(
							"Mask pattern must has x or #, where x for masking and # for digit display,example xx##, xxxx,x-x##");
				}
			}
		}
		int aMaskLength = countRepeatChar(mask, "x");
		aMaskLength = countRepeatChar(mask, "X");
		aMaskLength += countRepeatChar(mask, "#");
		if (aMaskLength != number.length()) {
			String errorMessage = String
					.format("Length of %s number is not matching with length  of %s mask; where as \"x#\" symbol is counted and rest are ignored",
							number, mask);
			throw new IllegalArgumentException(errorMessage);
		}
	}

	/**
	 * Count repeat char.
	 *
	 * @param aStrValue the a str value
	 * @param matchValue the match value
	 * @return the int
	 */
	private static int countRepeatChar(String aStrValue, String matchValue) {
		char charArrays[] = aStrValue.toCharArray();
		int count = 0;
		for (int i = 0; i < charArrays.length; i++) {
			if (charArrays[i] == matchValue.toCharArray()[0]) {
				count += 1;
			}
		}
		return count;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println(maskNumber("8105478242", "+91-### XX# ####"));
	}

}
