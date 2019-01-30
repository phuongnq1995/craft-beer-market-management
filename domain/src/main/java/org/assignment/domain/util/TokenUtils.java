package org.assignment.domain.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import org.springframework.security.crypto.codec.Hex;

/**
 * @author Phuongnq
 * TokenUtils
 */
public final class TokenUtils {

	public static final String SECRET_KEY = "oauth_craft_beer_market_secret_key_256_bit";

	public static final int EXPIRE_TIME = 3600000;

	public final static String AUTHENTICATION_TYPE = "Bearer";

	/**
	 * Generate expiration date
	 * @return Date after 1 hour
	 */
	public static Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + EXPIRE_TIME);
	}

	/**
	 * Generate Random Token
	 * @param clientId
	 * @return token
	 */
	public static String generateToken(String clientId) {
		StringBuilder builder = new StringBuilder();
		builder.append(SECRET_KEY);
		builder.append(clientId);
		builder.append(new Date());
		builder.append(EXPIRE_TIME);
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("No MD5 algorithm available!");
		}
		return new String(Hex.encode(digest.digest(builder.toString().getBytes())));
	}

	/**
	 * Validate token
	 * @param token
	 * @return true if valid else false
	 */
	public static boolean validateExpirationDate(Date date) {
		if(date == null || date.before(new Date())) {
			return false;
		}
		return true;
	}

	/**
	 * isValidateTokenFormat
	 * @param tokenValue
	 * @return true if valid else false
	 */
	public static boolean isValidateTokenFormat(String tokenValue) {
		if(tokenValue == null || tokenValue.isEmpty()) {
			return false;
		}
		return true;
	}

}
