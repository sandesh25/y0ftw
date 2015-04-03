package com.system.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class PasswordUtils {
	public static void main(String[] args) {
		System.out.println(encodePassword("jhambling"));
	}

	public static String encodePassword(String password) {
		StringBuffer encryptedValue = new StringBuffer("");
		try {
			byte[] dataInBytes = MessageDigest.getInstance("MD5").digest(password.getBytes());
			for (int index = 0; index < dataInBytes.length; index++)
				encryptedValue.append(Integer.toString((dataInBytes[index] & 0xff) + 0x100, 16).substring(1));
			return encryptedValue.toString();
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String generateNewPassword() {
		return UUID.randomUUID().toString().split("-")[0];
	}
}
