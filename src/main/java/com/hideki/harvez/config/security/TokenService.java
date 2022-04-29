package com.hideki.harvez.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.hideki.harvez.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expirationTime;
	
	@Value("${forum.jwt.secret}")
	private String secretKey;

	public String generateToken(Authentication authentication) {
		User loggedUser = (User) authentication.getPrincipal();
		
		Date now = new Date();
		Date tokenExpiration = new Date(now.getTime() + Long.parseLong(expirationTime));
		
		return Jwts.builder()
				.setIssuer("Harvez API")
				.setSubject(loggedUser.getId().toString())
				.setIssuedAt(now)
				.setExpiration(tokenExpiration)
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
	}
	
}
