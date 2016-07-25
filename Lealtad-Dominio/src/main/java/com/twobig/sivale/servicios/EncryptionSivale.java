package com.twobig.sivale.servicios;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.io.pem.PemReader;

import com.twobig.sivale.utils.PropUtils;

public class EncryptionSivale {
	private static final String ENCRYPTION_ALGORITHM = "RSA";
	private static PublicKey publicKey;

	public EncryptionSivale() {
	}

//	public static void main(String args[]) throws Throwable {
//		EncryptionSivale enc = new EncryptionSivale();
//		// //logger.info(enc.encryptData("V14j3s4pp_2015"));
//		//logger.info(enc.encryptData("latbc246"));
//	}

	public String encryptData(String data) throws Throwable {
		byte[] base64EncryptedData = null;

		PublicKey pubKey = getPublicKey();
		Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);

		byte[] encryptedData = cipher.doFinal(data.getBytes());
		base64EncryptedData = Base64.encode(encryptedData);

		return new String(base64EncryptedData);
	}

	private PublicKey getPublicKey() throws Throwable {
		
		if (EncryptionSivale.publicKey==null){		
			PemReader reader = null;
			PublicKey publicKey = null;
	
			try {
				
				InputStream inputStream = 
					      getClass().getClassLoader().getResourceAsStream("sivale_rsa_public.key");
				
				Reader readd = new InputStreamReader(inputStream);
				
				reader = new PemReader(readd);
	
				byte[] pubKey = reader.readPemObject().getContent();
				X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(pubKey);
	
				KeyFactory keyFactory = KeyFactory
						.getInstance(ENCRYPTION_ALGORITHM);
				publicKey = keyFactory.generatePublic(publicKeySpec);
			} catch (Throwable ex) {
				throw ex;
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException ex) {
					}
				}
			}
			EncryptionSivale.publicKey = publicKey;
		}
		return EncryptionSivale.publicKey;
	}

	private String getPublicKeyFileLocation() {
		return PropUtils.getProperties().getProperty("keyfile.location");
	}
}