package com.cc.ccadmin.util;

import org.apache.commons.codec.binary.Base64;

public final class PasswordService {

	public static byte[] encrypt(String Data) throws Exception {
		return (new String(Base64.encodeBase64(Data.getBytes()))).getBytes();

	}

	public static String decrypt(byte[] encryptedData) throws Exception {
		return new String(Base64.decodeBase64(encryptedData));
	}
}
