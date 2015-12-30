package in.com.pradeepit.core;

import in.com.pradeepit.service.util.NumberUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Functions {

	/**
	 * Utility method that encodes given URL
	 * 
	 * @param url
	 *            the url to encode
	 * @return encoded URL
	 */
	public static String encodeUrl(final String url) {
		try {
			return URLEncoder.encode(url, "UTF-8");
		} catch (final UnsupportedEncodingException e) {
			return url;
		}
	}

	/**
	 * @param number
	 *            The number in plain format
	 * @param mask
	 *            The mask pattern. Use # to include the digit from the
	 *            position. Use x to mask the digit at that position. Any other
	 *            char will be inserted.
	 * 
	 * @return The masked card number
	 */
	public static String maskNumber(String number, String mask) {

		return NumberUtil.maskNumber(number, mask);
	}


	public static void main(String[] args) {

		String account = "1234567898765432";
		System.out.println("account: " + account);

		System.out.println("Masked number examples:");

		// mask all bust last 4 numbers
		System.out.println(maskNumber(account, "xxxxxxxxxxxx####"));

		// insert dashes
		System.out.println(maskNumber(account, "####-####-####-####"));

		// insert dashes and mask all but last 4 numbers
		System.out.println(maskNumber(account, "xxxx-xxxx-xxxx-####"));
	}

}
