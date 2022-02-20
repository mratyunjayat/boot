package com.mt.example.boot.utility;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

import org.springframework.stereotype.Component;

@Component
public class AES {

	private static final String KEY_ALG = "AES";
	private static final int KEY_SIZE = 256;
	private static final String CIPHER_TRANSFORMATION = "AES/GCM/NoPadding";
	private static final int T_LEN = 128;

	private SecretKey key;
	private Cipher encryptionCipher;

	public void init() throws Exception {
		KeyGenerator generator = KeyGenerator.getInstance(KEY_ALG);
		generator.init(KEY_SIZE);
		key = generator.generateKey();
	}

	public String encrypt(String message) throws Exception {
		byte[] messageInBytes = message.getBytes();
		encryptionCipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
		encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedBytes = encryptionCipher.doFinal(messageInBytes);
		return encode(encryptedBytes);
	}

	public String decrypt(String encryptedMessage) throws Exception {
		byte[] messageInBytes = decode(encryptedMessage);
		Cipher decryptionCipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
		GCMParameterSpec spec = new GCMParameterSpec(T_LEN, encryptionCipher.getIV());
		decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
		byte[] decryptedBytes = decryptionCipher.doFinal(messageInBytes);
		return new String(decryptedBytes);
	}

	private String encode(byte[] data) {
		return Base64.getEncoder().encodeToString(data);
	}

	private byte[] decode(String data) {
		return Base64.getDecoder().decode(data);
	}

}
