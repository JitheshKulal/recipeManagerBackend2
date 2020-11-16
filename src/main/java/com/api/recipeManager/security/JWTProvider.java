package com.api.recipeManager.security;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.time.Instant;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.api.recipeManager.exception.RecipeManagerException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.Data;

import static io.jsonwebtoken.Jwts.parser;

@Data
@Service
public class JWTProvider {
	private KeyStore keyStore;
	@Value("${jwt-expire}")
	private Long JWTExpireTimeinMillisecs;
	
	@PostConstruct
	public void init() {
		try {
			keyStore = KeyStore.getInstance("JKS");
			InputStream resourceAsStream = getClass().getResourceAsStream("/springblog.jks");
			keyStore.load(resourceAsStream,"secret".toCharArray());
		} catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
			// TODO Auto-generated catch block
			throw new RecipeManagerException("Error while accessing Keystore");
		}
	}
	public String generateToken(Authentication authentication) {
		User principal = (User)authentication.getPrincipal();
		return Jwts.builder().setSubject(principal.getUsername())
				.signWith(getPrivateKey())
				//.setExpiration(Date.from(Instant.now().plusMillis(JWTExpireTimeinMillisecs)))
				.compact();
	}

	private PrivateKey getPrivateKey() {
		// TODO Auto-generated method stub
		try {
			return (PrivateKey) keyStore.getKey("springblog", "secret".toCharArray());
		} catch (UnrecoverableKeyException | KeyStoreException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RecipeManagerException("Error while retrieving Private key from keystore");
		}
	}
	public boolean validateToken(String jwt) {
		parser().setSigningKey(getPublicKey()).parseClaimsJws(jwt);
		return true;
	}
	private PublicKey getPublicKey() {
		// TODO Auto-generated method stub
		try {
			return keyStore.getCertificate("springblog").getPublicKey();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			throw new RecipeManagerException("Error while retrieving Public key from keystore");
		}
	}
	public String getUsernNameFromJWT (String jwt) {
		Claims claims = parser().setSigningKey(getPublicKey()).parseClaimsJws(jwt).getBody();
		return claims.getSubject();
	}
	
	public String generateTokenByUserName(String username) {
		// TODO Auto-generated method stub
		return Jwts.builder().setSubject(username)
				.signWith(getPrivateKey())
				//.setExpiration(Date.from(Instant.now().plusMillis(JWTExpireTimeinMillisecs)))
				.compact();
	}
	
}
