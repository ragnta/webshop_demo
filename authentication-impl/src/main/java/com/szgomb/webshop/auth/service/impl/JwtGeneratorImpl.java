package com.szgomb.webshop.auth.service.impl;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;

import com.szgomb.webshop.auth.model.UserDetailsImpl;
import com.szgomb.webshop.auth.service.JwtGenerator;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtGeneratorImpl implements JwtGenerator {

	@Value("${security.token.secret-key}")
	private String secretKey;
	
	@Value("${security.token.expiration}")
	private long jwtExpiration;

	/**
	 * ???? is it necessary?
	 * 
	 */
	public boolean validateToken(String token) {
		return !isTokenExpired(token);
	}

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public String generateToken(UserDetailsImpl user) {
		String username = user.getUsername();
		Date currentDate = new Date();
		Date expireDate = new Date(currentDate.getTime() + jwtExpiration);

		String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(expireDate)
				.signWith(getSignInKey(), SignatureAlgorithm.HS256).compact();
		return token;
	}

	/**
	 * 
	 * Extract claim field (eg.: iss, sub, exp) from the token
	 * 
	 * @param <T>            type of the field
	 * @param token
	 * @param claimsResolver
	 * @return
	 */
	private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	/**
	 * 
	 * extract all claim from the claims
	 * 
	 * @param token
	 * @return
	 */
	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
	}

	public String getUsernameFromJWT(String token) {
		return extractUsername(token);
	}

	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
