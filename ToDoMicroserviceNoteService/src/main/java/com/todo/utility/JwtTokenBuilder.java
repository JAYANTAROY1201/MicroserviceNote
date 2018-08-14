package com.todo.utility;

import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * purpose: this class is designed to build and deploy jwt token
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 10/07/18
 */
public class JwtTokenBuilder {
	final static String KEY = "JAYANTA";

	/**
	 * Method to access token
	 * 
	 * @param jwt
	 */
	public static Claims parseJWT(String jwt) {

		// This line will throw an exception if it is not a signed JWS (as expected)
		return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(KEY)).parseClaimsJws(jwt).getBody();

	}
}
