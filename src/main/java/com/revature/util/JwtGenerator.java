package com.revature.util;

import java.util.Date;

import com.revature.models.User;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtGenerator {
	public static String createJwt(User subject) {
		System.out.println("Creating new JWT for: " + subject.getUsername());
		
		// The JWT Signature Algorithm used to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		
		long nowMillis = System.currentTimeMillis();
		
		// Configure the JWT and set its claims
		JwtBuilder builder = Jwts.builder()
				.setId(Integer.toString(subject.getUser_id()))
				.setSubject(subject.getUsername())
				.setIssuer("takoot")
				.claim("password", subject.getPassword())
				.setExpiration(new Date(nowMillis + JwtConfig.EXPIRATION * 1000))
				.signWith(signatureAlgorithm, JwtConfig.signingKey);
		
		System.out.println("JWT successfully created");
		
		// Build the JWT and serialize it into a compact, URL-safe string
		return builder.compact();
	}
	
	private JwtGenerator() {
		super();
	}

}
