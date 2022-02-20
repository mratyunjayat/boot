package com.mt.example.boot.utility;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class AESTest {

//	@InjectMocks
//	private AES aes;

	@Test
	void test() throws Exception {
		AES aes = new AES();
		aes.init();
		String encryptedMessage = aes.encrypt("Hello AES Encryption");
		System.out.println("Encrypted Message : " + encryptedMessage);

		String decryptedMessage = aes.decrypt(encryptedMessage);

		System.out.println("Decrypted Message : " + decryptedMessage);
	}

}
