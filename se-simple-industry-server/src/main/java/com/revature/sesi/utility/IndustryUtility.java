package com.revature.sesi.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.RandomStringUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class IndustryUtility {

	private static Key jwtsecretKey;

	static {
		jwtsecretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	}

	public static String createSignedJsonWebTokenWithEmailSubject(String email) {

		String jws = Jwts.builder().setSubject(email).signWith(jwtsecretKey).compact();
		return jws;

	}

	public static String getEmailSubjectFromSignedJsonWebToken(String jws) {

		return Jwts.parser().setSigningKey(jwtsecretKey).parseClaimsJws(jws).getBody().getSubject();

	}

	/**
	 * 
	 * Send an email with the given details via Yahoo server using a personal
	 * account
	 * 
	 * @param recipient
	 * @param subject
	 * @param content
	 */
	public static void sendEmail(String recipient, String subject, String content) {

		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		InputStream in = cl.getResourceAsStream("email.properties");
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.mail.yahoo.com");
		props.put("mail.smtp.port", "587");
		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}

		final String username = props.getProperty("username");
		final String password = props.getProperty("password");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(username));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject(subject);
			message.setText(content);
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Read the servlet request body and produce a string representation
	 * 
	 * @param br
	 * @return the parsed request body in string format
	 */
	public static String readRequest(BufferedReader br) {

		StringBuilder requestBody = new StringBuilder("");
		String buffer = null;

		try {
			while ((buffer = br.readLine()) != null) {
				requestBody.append(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (requestBody.length() == 0) {
			return null;
		} else {
			return new String(requestBody);
		}

	}

	/**
	 * 
	 * Generate a random alphanumeric string of the specified length
	 * 
	 * @param length
	 * @return the generated random string
	 */
	public static String generateRandomString(int length) {

		return RandomStringUtils.randomAlphanumeric(length);

	}

}
